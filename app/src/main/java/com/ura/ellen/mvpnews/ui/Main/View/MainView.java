package com.ura.ellen.mvpnews.ui.Main.View;

import android.support.v4.app.Fragment;

import com.ura.ellen.baselibrary.presenter.view.BaseView;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.Mode.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

public interface MainView extends BaseView {


    /**
     * 完成底部的页面更新
     * @param fragment
     * @param id
     */
    void qieHuanMainBootomPager(Fragment fragment, int id,int value);

    /**
     * 更新视频数据
     * @param json
     * @param what
     */
    void upDateVideoData(String json,int what);

    /**
     * 更新首页页面Tab
     * @param json
     */
    void upDateNewsPagerTab(String json);

    /**
     * 更新首页页面新闻的第p页数据
     * @param p
     * @param json
     */
    void upDateNewsData(int p,String json,int what);

    void upDateLocalRes(List<LocalRes> localRes,int p,int what);

    void yeHua();

    void cancelYeHua();

    void upDateLocalNewsData(List<News.DataBean.ItemListBean> itemListBeans,List<News.DataBean.BigImgBean> bigImgBeans,int p,int what);

}
