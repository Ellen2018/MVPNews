package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.recyclerview.NewsAdapter;
import com.ura.ellen.mvpnews.adapter.recyclerview.NewsAdapter2;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.utils.JsonUtils;
import com.ura.ellen.mvpnews.utils.NetUtils;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class NewsViewPagerFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.lv_fragment_pager1)
    RecyclerView lvViewpagerfragmentPager1;
    @BindView(R.id.pb_viewpagerfragment_pager1)
    ProgressBar pbViewpagerfragmentPager1;
    @BindView(R.id.ptrl_viewpagerfragment_pager1)
    PullToRefreshLayout ptrlViewpagerfragmentPager1;
    @BindView(R.id.iv_viewpagerfragment_top)
    ImageView top;

    @OnClick(R.id.iv_viewpagerfragment_top)
    void top(){
        lvViewpagerfragmentPager1.smoothScrollToPosition(0);
    }

    private MainPresenter mainPresenter;

    private String url;



    private RecyclerView.Adapter newsAdapter2;

    private int p;




    //http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataInfoNew?n2=40&id=Nav-9Nwml0dIB6wAxgd9EfZA160510&n1=3&version=1

    private List<News.DataBean.BigImgBean> bigImgBeans;
    private List<News.DataBean.ItemListBean> itemListBeans;

    private List<News.DataBean> dataBeans;

    public NewsViewPagerFragment(String url, int p) {

        this.url = url;
        //this.url = "http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataInfoNew?n2=20&id=Nav-9Nwml0dIB6wAxgd9EfZA160510&n1=3&version=1";
        this.p = p;

    }





    @Override
    public void yeHua() {

        if(newsAdapter2!=null) {
            newsAdapter2.notifyDataSetChanged();
        }

    }

    @Override
    public void cancelYeHua() {
        if(newsAdapter2!=null) {
            newsAdapter2.notifyDataSetChanged();
        }
    }


    public void upDateFromLocal() {


        if(itemListBeans == null) {
            mainPresenter.getLocalNewsData(p, USER_LOCAL);
        }else{
            autoRefresh();
        }



    }


    /**
     * 用户下拉更新时调用
     */
    public void upDateFromNetRefresh() {

        mainPresenter.requestNewsData(url,p,USER_REFRESH_DOWN);

    }

    /**
     * 用户下拉更新时调用
     */
    public void upDateFromNetLaodMore(){

        n2 = n2 + fenYeNumber;

        String  loadMoreUrl = this.url.replace("n2=20","n2="+n2);

        //这里地方只需要把请求地址变成相应的地址即可
        mainPresenter.requestNewsData(loadMoreUrl,p,USER_LOADMORE_UP);

    }



    /**
     * 这里运行在子线程,P层回调的方法
     *
     * @param json
     */
    public void upDateData(String json,int what){
        News.DataBean dataBean = null;
        Message message = new Message();
        if(itemListBeans!=null&&itemListBeans.size()>0) {
            message.arg2 = itemListBeans.size();
        }
        switch (what){

            case USER_REFRESH_DOWN:

                dataBean = JsonUtils.getDataBeanFronJson(json);

                if(bigImgBeans == null) {
                    bigImgBeans = dataBean.getBigImg();
                }else{
                    //刷新数据
                    bigImgBeans.clear();
                    List<News.DataBean.BigImgBean> arrayList = dataBean.getBigImg();
                    for(News.DataBean.BigImgBean bigImgBean:arrayList){
                        bigImgBeans.add(bigImgBean);
                    }

                }

                if(itemListBeans.size() == 0) {
                    itemListBeans = dataBean.getItemList();
                    message.arg1 = itemListBeans.size();
                }else{

                    List<News.DataBean.ItemListBean> arrayList = dataBean.getItemList();

                    for(int i=0;i<arrayList.size();i++){
                        boolean isAdd = true;
                        for(int j =0;j<itemListBeans.size();j++){
                            if(itemListBeans.get(j).getDetailUrl().equals(arrayList.get(i).getDetailUrl())){
                                //说明这条数据是一样的
                                isAdd = false;
                                break;
                            }
                        }

                        if(isAdd){
                            message.arg1++;
                            itemListBeans.add(0,arrayList.get(i));
                        }

                    }

                }



                if(message.arg1>0) {
                    mainPresenter.saveNewsDataToLocal(getActivity(),itemListBeans,bigImgBeans,p);
                }






                break;

            case USER_LOADMORE_UP:

                dataBean = JsonUtils.getDataBeanFronJson(json);

                List<News.DataBean.ItemListBean> arrayList = dataBean.getItemList();



                for(int i=0;i<arrayList.size();i++){
                    boolean isAdd = true;
                    for(int j =0;j<itemListBeans.size();j++){
                        if(itemListBeans.get(j).getDetailUrl().equals(arrayList.get(i).getDetailUrl())){
                            //说明这条数据是一样的
                            isAdd = false;
                            break;
                        }
                    }

                    if(isAdd){
                        itemListBeans.add(arrayList.get(i));
                    }

                }



                break;

            case USER_LOCAL:

                break;

            case USER_LOAD_FAIL:

                break;

        }



        message.what = what;
        myUpdateHandler.sendMessage(message);

    }


    public void upDateDataLocal(List<News.DataBean.ItemListBean> itemListBeans,List<News.DataBean.BigImgBean> bigImgBeans,int what){
        this.itemListBeans = itemListBeans;
        this.bigImgBeans = bigImgBeans;
        myUpdateHandler.sendEmptyMessage(what);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("" + url, "可见");
        } else {
            Log.e("" + url, "不可见");
            //在这里进行UI或者内存资源的回收
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager_pager1, null);
        unbinder = ButterKnife.bind(this, view);
        //这里读取isSaveData,来判断用户是否进行了本地存储

        //设置RecyclerView 布局管理器
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        lvViewpagerfragmentPager1.setLayoutManager(layoutmanager);
        //设置ecyclerView分割线
        //lvViewpagerfragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        MainActivity mainActivity = (MainActivity) getActivity();
        mainPresenter = mainActivity.mPresenter;
        myUpdateHandler = new MyUpdateHandler();

        if (p == 0) {

            upDateFromLocal();

        }


        setListener();


        return view;
    }

    private void setListener() {

        ptrlViewpagerfragmentPager1.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                if(!NetUtils.isNetCanUse(getActivity())) {
                    ToastUtil.toast(getActivity(),"网络不可用！");
                    ptrlViewpagerfragmentPager1.finishRefresh();
                    return;
                }
                upDateFromNetRefresh();
            }

            @Override
            public void loadMore() {

                if(!NetUtils.isNetCanUse(getActivity())) {
                    ToastUtil.toast(getActivity(),"网络不可用！");
                    ptrlViewpagerfragmentPager1.finishLoadMore();
                    return;
                }
                //NewsViewPagerFragment.this.url = "http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataInfoNew?n2=40&id=Nav-9Nwml0dIB6wAxgd9EfZA160510&n1=3&version=1";
                upDateFromNetLaodMore();
            }
        });

        lvViewpagerfragmentPager1.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                top.setVisibility(View.VISIBLE);
                super.onScrollStateChanged(recyclerView, newState);
            }

        });


    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void autoRefresh(){
        ptrlViewpagerfragmentPager1.autoRefresh();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    class MyUpdateHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case USER_REFRESH_DOWN:

                    //下拉更新
                    pbViewpagerfragmentPager1.setVisibility(View.GONE);


                    if(newsAdapter2 == null) {
                        if( p ==0) {
                            newsAdapter2 = new NewsAdapter2(getActivity(), getActivity(), itemListBeans, bigImgBeans);
                        }else{
                            newsAdapter2 = new NewsAdapter(getActivity(),getActivity(),itemListBeans,bigImgBeans);
                        }
                        lvViewpagerfragmentPager1.setAdapter(newsAdapter2);
                    }else{

                        if(msg.arg1>0) {
                            newsAdapter2.notifyDataSetChanged();
                            if( p == 0) {
                                ((NewsAdapter2)newsAdapter2).notifyHeadViewData(bigImgBeans);
                            }else{
                                ((NewsAdapter)newsAdapter2).notifyHeadViewData(bigImgBeans);
                            }
                        }else{
                            ToastUtil.toast(getActivity(),"暂无更新！");
                            if( p == 0) {
                                ((NewsAdapter2)newsAdapter2).notifyHeadViewData(bigImgBeans);
                            }else{
                                ((NewsAdapter)newsAdapter2).notifyHeadViewData(bigImgBeans);
                            }
                        }

                    }


                    ptrlViewpagerfragmentPager1.finishRefresh();



                    break;

                case USER_LOADMORE_UP:
                    //上拉加载更多时调用
                    ToastUtil.toast(getActivity(),"上拉加载更多！");
                    newsAdapter2.notifyDataSetChanged();
                    ptrlViewpagerfragmentPager1.finishLoadMore();
                    lvViewpagerfragmentPager1.smoothScrollToPosition(msg.arg2+1);

                    break;

                case USER_LOCAL:
                    //本地加载时调用

                    if(itemListBeans.size()>0) {
                        if (p == 0) {
                            newsAdapter2 = new NewsAdapter2(getActivity(), getActivity(), itemListBeans, bigImgBeans);
                        } else {
                            newsAdapter2 = new NewsAdapter(getActivity(), getActivity(), itemListBeans, bigImgBeans);
                        }
                        lvViewpagerfragmentPager1.setAdapter(newsAdapter2);
                    }


                    autoRefresh();

                    break;

                case USER_LOAD_FAIL:
                    //请求网络失败的时候调用
                    ToastUtil.toast(getActivity(),"网络错误！加载数据失败");
                    ptrlViewpagerfragmentPager1.finishRefresh();
                    ptrlViewpagerfragmentPager1.finishLoadMore();
                    break;


            }


            pbViewpagerfragmentPager1.setVisibility(View.GONE);

        }
    }


}