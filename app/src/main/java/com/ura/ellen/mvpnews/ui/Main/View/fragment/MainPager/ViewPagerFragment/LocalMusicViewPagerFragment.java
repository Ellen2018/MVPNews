package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.adapter.recyclerview.LocalImageAdapter;
import com.ura.ellen.mvpnews.adapter.recyclerview.LocalMusicAdapter;
import com.ura.ellen.mvpnews.adapter.recyclerview.LocalVideoAdapter;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class LocalMusicViewPagerFragment extends BaseFragment {


    @BindView(R.id.rv_listview_local_video)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private String url;
    private int p;


    private MainPresenter mainPresenter;

    private RecyclerView.Adapter adapter;
    private List<LocalRes> localRes;

    public LocalMusicViewPagerFragment(String url, int p) {
        this.url = url;
        this.p = p;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager_pager3, null);
        unbinder = ButterKnife.bind(this, view);

        //设置RecyclerView 布局管理器
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutmanager);

        MainActivity mainActivity = (MainActivity) getActivity();
        mainPresenter = mainActivity.mPresenter;

        myUpdateHandler = new MyHandler();


        if(p == 0){
            autoRefresh();
        }

        return view;
    }

    @Override
    public void yeHua() {

        if(adapter!=null)
        adapter.notifyDataSetChanged();

    }

    @Override
    public void cancelYeHua() {
        if(adapter!=null)
            adapter.notifyDataSetChanged();

    }

    @Override
    public void autoRefresh() {

        mainPresenter.getLocalRes(url,p,USER_LOCAL);

    }

    @Override
    public void upDateFromNetRefresh() {

    }

    @Override
    public void upDateFromLocal() {

    }

    @Override
    public void upDateFromNetLaodMore() {

    }

    @Override
    public void upDateData(String json, int what) {

    }


    public void upDateData(List<LocalRes> localRes,int what){

       this.localRes = localRes;
        myUpdateHandler.sendEmptyMessage(what);
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
               case USER_LOCAL:
                   if(url.equals("视频")){
                       adapter = new LocalVideoAdapter(getActivity(),localRes);
                       recyclerView.setAdapter(adapter);
                   }else if(url.equals("图片")){
                       adapter = new LocalImageAdapter(getActivity(),localRes);
                       recyclerView.setAdapter(adapter);
                   }else if(url.equals("音乐")){
                       adapter = new LocalMusicAdapter(getActivity(),localRes);
                       recyclerView.setAdapter(adapter);
                   }
                   break;
           }
        }
    }

}
