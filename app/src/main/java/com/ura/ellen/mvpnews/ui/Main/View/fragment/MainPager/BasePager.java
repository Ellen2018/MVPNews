package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager;

import android.view.View;

import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;

public abstract class BasePager {

    public boolean isInit = false;

    public MainPresenter mainPresenter; //上下文

    public View rootView;

    public BasePager(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
        rootView = initView();
    }

    public abstract View initView();//初始化页面View

    public abstract void yeHua();

    public abstract void cancelYeHua();

    //第一次更新的时候调用
    public abstract void onUpDate();

    //初始化页面数据时调用
    public void initData(){
        isInit = true;
    }


    public abstract void changOnBackgroundAgo();


}
