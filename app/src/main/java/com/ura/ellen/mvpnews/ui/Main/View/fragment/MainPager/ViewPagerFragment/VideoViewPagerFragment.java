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
import android.widget.ProgressBar;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.recyclerview.VideoAdapter;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.utils.JsonUtils;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class VideoViewPagerFragment extends BaseFragment {

    @BindView(R.id.lv_viewpagerfragment_pager2)
    RecyclerView lvViewpagerfragmentPager2;
    @BindView(R.id.pb_viewpagerfragment_pager2)
    ProgressBar pbViewpagerfragmentPager2;
    Unbinder unbinder;
    @BindView(R.id.prfl_viewpagerfragment_pager2)
    PullToRefreshLayout pullToRefreshLayout;

    //请求地址
    private String url;
    //位置
    private int p;

    private MainPresenter mainPresenter;
    private MyHandler myHandler;

    private VideoAdapter videoAdapter;
    private List<TrailersBean> arrayList;

    private final int AUTO_REFRSH = 0,USER_REFERSH_DOWN = 1,USER_LOADMORE_UP = 2,USER_LOCAL = 3,USER_LOAD_FAIL = 4;

    public VideoViewPagerFragment(String url,int p) {
        this.url = url;
        this.p = p;
    }

    @Override
    public void yeHua() {

    }

    @Override
    public void cancelYeHua() {

    }

    @Override
    public void autoRefresh() {

    }


    public void upDateFromLocal() {

        if(arrayList==null||arrayList.size()==0){
            //从本地加载
           arrayList = mainPresenter.getAllLocalVideoData();

           //当从本地获取的数据为空，或者数据的数量为0的时候，从网络获取数据
           if(arrayList == null||arrayList.size() == 0){
               upDateFromNetRefresh();
               ToastUtil.toast(getActivity(),"从网络加载的数据");
           }else{
               ToastUtil.toast(getActivity(),"从本地加载的数据");
               myHandler.sendEmptyMessage(USER_LOCAL);
           }

        }

    }


    /**
     * 用户下拉更新时调用
     */
    public void upDateFromNetRefresh() {

        mainPresenter.requestVideoNetData(url,USER_REFERSH_DOWN);

    }

    /**
     * 用户上拉加载更多时调用
     */
    public void upDateFromNetLaodMore(){

        //这里地方只需要把请求地址变成相应的地址即可
        mainPresenter.requestVideoNetData(url,USER_LOADMORE_UP);

    }

    @Override
    public void upDateData(String json, int what) {

        if(json == null){
            //发送消息到主线程告诉用户无网络，或者加载过长
            myHandler.sendEmptyMessage(USER_LOAD_FAIL);
            return;
        }

        Message message = new Message();

        switch (what){

            case AUTO_REFRSH:

                arrayList = JsonUtils.getListTrailersBeanFromJson(json);
                mainPresenter.saveVideoDatasToLocal(arrayList);

                break;

            case USER_REFERSH_DOWN:

                List<TrailersBean> netLists = JsonUtils.getListTrailersBeanFromJson(json);

                int number = 0;

                for(int i = netLists.size()-1;i>=0;i-- ){

                    boolean isAdd = true;
                    for(int j=0;j<arrayList.size();j++){
                        if(arrayList.get(j).getHightUrl().equals(netLists.get(i).getHightUrl())){
                            isAdd = false;
                            break;
                        }
                    }

                    if(isAdd){
                        //添加该条目到头部
                        number ++;
                        arrayList.add(0,netLists.get(i));
                    }

                }

                //添加的存储到本地
                mainPresenter.saveVideoDatasAndClearAllData(arrayList);

                message.arg2 = number;

                break;

            case USER_LOADMORE_UP:

                arrayList.addAll(JsonUtils.getListTrailersBeanFromJson(json));

                mainPresenter.saveVideoDatasAndClearAllData(arrayList);

                break;
        }



        message.what = what;
        myHandler.sendMessage(message);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

        } else {
           stop();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager_pager2, null);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        lvViewpagerfragmentPager2.setLayoutManager(layoutmanager);
        lvViewpagerfragmentPager2.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        MainActivity mainActivity = (MainActivity) getActivity();
        mainPresenter = mainActivity.mPresenter;
        myHandler = new MyHandler();

        //设置监听事件
        setListener();

        //如果是第一个就自动刷新
        if(p == 0){
            onFirstUpdate();
        }

        return view;
    }

    /**
     * 设置监听事件
     */
    private void setListener() {

        pullToRefreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                upDateFromNetRefresh();
            }

            @Override
            public void loadMore() {
               upDateFromNetLaodMore();
            }
        });

    }

    /**
     * 第一个页面第一次加载时调用
     */
    private void onFirstUpdate(){

        upDateFromLocal();

    }


    @Override
    public void onDestroyView() {
        videoAdapter.stop();
        super.onDestroyView();
        unbinder.unbind();
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {

            pbViewpagerfragmentPager2.setVisibility(View.GONE);
            switch (msg.what) {


                case AUTO_REFRSH:


                 //自动更新
                videoAdapter = new VideoAdapter(getActivity(),arrayList);
                lvViewpagerfragmentPager2.setAdapter(videoAdapter);

                    break;

                case USER_REFERSH_DOWN:


                    //用户下拉跟新
                    videoAdapter = new VideoAdapter(getActivity(),arrayList);
                    lvViewpagerfragmentPager2.setAdapter(videoAdapter);


                    if(msg.arg2==0){
                        ToastUtil.toast(getActivity(),"暂无更新!");
                    }else{
                        ToastUtil.toast(getActivity(),"已更新"+msg.arg2+"条内容！");
                    }


                    // 结束刷新
                    pullToRefreshLayout.finishRefresh();


                    break;


                case USER_LOADMORE_UP:

                    // 上拉加载更多
                    pullToRefreshLayout.finishLoadMore();
                    ToastUtil.toast(getActivity(),"下拉加载更多成功！");
                    videoAdapter.notifyDataSetChanged();

                    break;

                case USER_LOCAL:

                    //本地加载时
                    pbViewpagerfragmentPager2.setVisibility(View.GONE);
                    videoAdapter = new VideoAdapter(getActivity(),arrayList);
                    lvViewpagerfragmentPager2.setAdapter(videoAdapter);


                    break;

                case USER_LOAD_FAIL:

                    //加载失败时
                    ToastUtil.toast(getActivity(),"无网络状态，加载数据失败！");
                    pullToRefreshLayout.finishLoadMore();
                    pullToRefreshLayout.finishRefresh();

                    break;

            }


        }
    }


    /**
     * 当切换底部对应的主页面时调用来停止当前的页面的所有动作
     */
    public void stop(){

        if(videoAdapter != null) {
            videoAdapter.stop();
        }
    }

}
