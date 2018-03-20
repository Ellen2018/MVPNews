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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.recyclerview.NewsZhiBoAdapter;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.utils.JsonUtils;
import com.ura.ellen.mvpnews.utils.NetUtils.NetUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class NewsZhiBoViewPagerFragment extends BaseFragment {


    @BindView(R.id.lv_fragment_pager1)
    RecyclerView lvFragmentPager1;
    @BindView(R.id.ptrl_viewpagerfragment_pager1)
    PullToRefreshLayout ptrlViewpagerfragmentPager1;
    @BindView(R.id.pb_viewpagerfragment_pager1)
    ProgressBar pbViewpagerfragmentPager1;
    @BindView(R.id.iv_viewpagerfragment_top)
    ImageView ivViewpagerfragmentTop;
    Unbinder unbinder;
    private String url;
    private int p;
    private MainPresenter mainPresenter;

    private List<News.DataBean.ItemListBean> arrayList;



    public NewsZhiBoViewPagerFragment(String url, int p) {

        this.url = url;
        this.p = p;

    }

    private NewsZhiBoAdapter newsZhiBoAdapter;

    @Override
    public void yeHua() {

    }

    @Override
    public void cancelYeHua() {

    }

    @Override
    public void autoRefresh() {

        ptrlViewpagerfragmentPager1.autoRefresh();

    }

    @Override
    public void upDateFromNetRefresh() {
        mainPresenter.requestNewsData(url,p,USER_REFRESH_DOWN);
    }

    @Override
    public void upDateFromLocal() {

        if(arrayList == null){
            mainPresenter.getLocalNewsData(p, USER_LOCAL);
        }else {
            autoRefresh();
        }


    }

    @Override
    public void upDateFromNetLaodMore() {


        String url = this.url.replace("n2=20","n2="+n2);
        mainPresenter.requestNewsData(url,p,USER_LOADMORE_UP);

    }

    @Override
    public void upDateData(String json, int what) {


        News.DataBean dataBean = null;

        Message message = new Message();

        if(arrayList!=null&&arrayList.size()>0){
            message.arg2 = arrayList.size();
        }

        switch (what){

            case USER_REFRESH_DOWN:

                dataBean = JsonUtils.getDataBeanFronJson(json);
                List<News.DataBean.ItemListBean> itemListBeans = dataBean.getItemList();

                if(arrayList.size() == 0) {
                    arrayList = dataBean.getItemList();
                    message.arg1 = arrayList.size();
                }else{

                    for(int i=0;i<itemListBeans.size();i++){
                        boolean isAdd = true;
                        for(int j =0;j<arrayList.size();j++){
                            if(arrayList.get(j).getDetailUrl().equals(itemListBeans.get(i).getDetailUrl())){
                                //说明这条数据是一样的
                                isAdd = false;
                                break;
                            }
                        }

                        if(isAdd){
                            message.arg1++;
                            arrayList.add(0,itemListBeans.get(i));
                        }

                    }


                }

                if(arrayList.size()>0) {
                   mainPresenter.saveNewsDataToLocal(getActivity(),arrayList,null,p);
                }

                break;

            case USER_LOADMORE_UP:

                dataBean = JsonUtils.getDataBeanFronJson(json);
                List<News.DataBean.ItemListBean> lists = dataBean.getItemList();

                for(int i=0;i<lists.size();i++){
                    boolean isAdd = true;
                    for(int j =0;j<arrayList.size();j++){
                        if(arrayList.get(j).getDetailUrl().equals(lists.get(i).getDetailUrl())){
                            //说明这条数据是一样的
                            isAdd = false;
                            break;
                        }
                    }

                    if(isAdd){
                        arrayList.add(lists.get(i));
                    }

                }

                break;

        }

        message.what = what;
        myUpdateHandler.sendMessage(message);


    }

    public void upDateDataLocal(List<News.DataBean.ItemListBean> itemListBeans,List<News.DataBean.BigImgBean> bigImgBeans,int what){
        arrayList = itemListBeans;
        myUpdateHandler.sendEmptyMessage(what);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager_pager1, null);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        lvFragmentPager1.setLayoutManager(layoutmanager);
        //设置ecyclerView分割线
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        lvFragmentPager1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));


        MainActivity mainActivity = (MainActivity) getActivity();
        mainPresenter = mainActivity.mPresenter;
        myUpdateHandler = new MyHandler();

        setListener();


        return view;
    }

    private void setListener() {

        ptrlViewpagerfragmentPager1.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {

                if(!NetUtils.isNetCanUse(getActivity())){
                    ToastUtil.toast(getActivity(),"网络不可用！");
                    ptrlViewpagerfragmentPager1.finishRefresh();
                    return;
                }
                upDateFromNetRefresh();
            }

            @Override
            public void loadMore() {
                if(!NetUtils.isNetCanUse(getActivity())){
                    ToastUtil.toast(getActivity(),"网络不可用！");
                    ptrlViewpagerfragmentPager1.finishLoadMore();
                    return;
                }
                //NewsViewPagerFragment.this.url = "http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataInfoNew?n2=40&id=Nav-9Nwml0dIB6wAxgd9EfZA160510&n1=3&version=1";
                upDateFromNetLaodMore();
            }
        });

        lvFragmentPager1.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                ivViewpagerfragmentTop.setVisibility(View.VISIBLE);
                super.onScrollStateChanged(recyclerView, newState);
            }

        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case USER_REFRESH_DOWN:

                    if(newsZhiBoAdapter == null) {
                        newsZhiBoAdapter = new NewsZhiBoAdapter(getActivity(), arrayList);
                        lvFragmentPager1.setAdapter(newsZhiBoAdapter);
                    }else{

                        if(msg.arg1>0){
                            newsZhiBoAdapter.notifyDataSetChanged();
                        }else{
                            ToastUtil.toast(getActivity(),"暂无更新！");
                        }

                    }
                    ptrlViewpagerfragmentPager1.finishRefresh();

                    break;

                case USER_LOADMORE_UP:

                    newsZhiBoAdapter.notifyDataSetChanged();

                    ptrlViewpagerfragmentPager1.finishLoadMore();
                    lvFragmentPager1.smoothScrollToPosition(msg.arg2);

                    break;

                case USER_LOCAL:

                    if(arrayList.size()>0) {
                        newsZhiBoAdapter = new NewsZhiBoAdapter(getActivity(), arrayList);
                        lvFragmentPager1.setAdapter(newsZhiBoAdapter);
                    }
                    autoRefresh();

                    break;

            }

            pbViewpagerfragmentPager1.setVisibility(View.GONE);
        }
    }

}
