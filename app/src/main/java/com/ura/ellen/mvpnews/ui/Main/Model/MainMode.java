package com.ura.ellen.mvpnews.ui.Main.Model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;


import com.ura.ellen.baselibrary.presenter.BaseMode;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.Mode.TabClass;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.Mode.Video;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.LocalMusicViewPagerFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.NewsViewPagerFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.BasePager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.NewsPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.LocalPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.UserPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.VideoPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.NewsWebViewpagerFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.NewsZhiBoViewPagerFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.VideoViewPagerFragment;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.utils.ContentProviderUtils;
import com.ura.ellen.mvpnews.utils.GreenDaoUtils.TabClassGreenUtils;
import com.ura.ellen.mvpnews.utils.GreenDaoUtils.VideoGreenDaoUtils;
import com.ura.ellen.mvpnews.utils.NetUtils.MyOkHttpUtils;
import com.ura.ellen.mvpnews.utils.NetUtils.NetUtils;
import com.ura.ellen.mvpnews.utils.SQLiteUtils.NewsSQLiteUtils;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainMode extends BaseMode {

    private VideoGreenDaoUtils videoGreenDaoUtils;
    private TabClassGreenUtils tabClassGreenUtils;


    public void saveTabData(List<TabClass> tabClasses){
        tabClassGreenUtils.saveAllTabData(tabClasses);
    }


    public List<TabClass> getTabClass(){
        return tabClassGreenUtils.queryAll();
    }


    /**
     * 保存一个TrailersBean集合数据，保存之前去除所有数据
     * @param lists
     */
    public void saveVideoDatasAndClearAllData(List<TrailersBean> lists){
       videoGreenDaoUtils.saveVideoDatasAndClearAllData(lists);
    }

    /**
     * 保存单条的Video数据到数据库
     * @param trailersBean
     */
    public void saveVideoDataToLocal(TrailersBean trailersBean){
        videoGreenDaoUtils.saveVideoData(trailersBean);
    }

    public void saveVideoDatasToLocal(List<TrailersBean> lists){
       videoGreenDaoUtils.saveVideoDatasToLocal(lists);
    }

    public List<TrailersBean> getAllLocalVideoData(){
        return videoGreenDaoUtils.getAllLocalVideoData();
    }

    public MainMode(){

        videoGreenDaoUtils = new VideoGreenDaoUtils();
        tabClassGreenUtils = new TabClassGreenUtils();
    }


    /**
     * 首页的所有Fragment集合
     */
    private ArrayList<BaseFragment> viewpagerFragmentsPager1;

    /**
     * 视频的所有标题集合
     */
    private ArrayList<String>  tabLayoutStringsPager2;

    /**
     * 视频的所有Fragment集合
     */
    private ArrayList<BaseFragment> viewpagerFragmentsPager2;

    /**
     * 底部导航栏对应的页面BasePager集合
     */
    private ArrayList<BasePager> basePagers;


    /**
     * 用户切换底部的时候调用
     * @return
     */
    public BaseFragment getMainFragment() {
        mainFragment = new MainFragment(getBasePager());
        return mainFragment;
    }

    /**
     * 底部导航栏对应的当前的Fragment
     */
    private BaseFragment mainFragment;

    /**
     * 获取底部导航栏对应BasePager集合
     * @param mainPresenter
     * @return
     */
    public ArrayList<BasePager> getBasePagers(MainPresenter mainPresenter) {
        if(basePagers == null){
            basePagers = new ArrayList<>();
            basePagers.add(new NewsPager(mainPresenter));
            basePagers.add(new VideoPager(mainPresenter));
            basePagers.add(new LocalPager(mainPresenter));
            basePagers.add(new UserPager(mainPresenter));
        }
        return basePagers;
    }


    /**
     * 请求网络，并返回请求的数据
     * @param url
     * @return
     */
    public String requestNet(String url) throws IOException {

        return MyOkHttpUtils.getInstance().getJson(url);
    }

    /**
     * 获取上下文
     * @return
     */
    public Context getContext() {
        return context;
    }

    /**
     * 设置上下文
     * @param context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 上下文
     */
    private Context context;

    /**
     * 获取activity
     * @return
     */
    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    /**
     * 设置activity
     * @return
     */
    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    /**
     * activity
     */
    private FragmentActivity fragmentActivity;


    /**
     * 获取底部导航栏的BasePager对象，并且完成数据的初始化
     * @return
     */
    public BasePager getBasePager() {

        if(basePager != null&&!basePager.isInit){
            basePager.initData();
        }
        return basePager;
    }

    /**
     * 设置导航栏对应的当前的BasePager
     * @param basePager
     */
    public void setBasePager(BasePager basePager) {
        this.basePager = basePager;
    }

    /**
     * 当前的底部导航栏对应的BasePager
     */
    private BasePager basePager;

    //底部导航栏的位置
    private int pagerInt = -1;
    public int getPagerInt() {
        return pagerInt;
    }
    public void setPagerInt(int pagerInt) {
        this.pagerInt = pagerInt;
    }


    /**
     * 得到视频页面的Tab的titles
     * @return
     */
    public ArrayList<String> getTabLayoutStringsPager2() {
        if(tabLayoutStringsPager2 == null){
            tabLayoutStringsPager2 = new ArrayList<>();
            //这个地方应该读取数据库
            tabLayoutStringsPager2.add("推荐");
            tabLayoutStringsPager2.add("搞笑");
            tabLayoutStringsPager2.add("影视");
            tabLayoutStringsPager2.add("音乐");
            tabLayoutStringsPager2.add("现场");
            tabLayoutStringsPager2.add("黑科技");
            tabLayoutStringsPager2.add("小品");
        }
        return tabLayoutStringsPager2;
    }



    /**
     * 得到视频页面的Tab的titles
     * @return
     */
    public ArrayList<String> getTabLayoutStringsPager3() {
        ArrayList<String> arrayList = new ArrayList<>();

            arrayList.add("视频");
            arrayList.add("图片");
            arrayList.add("音乐");

            return arrayList;

    }

    /**
     * 得到视频页面的Tab的titles
     * @return
     */
    public ArrayList<BaseFragment> getTabLayoutStringsPager3(ArrayList<String> tabStrings) {
        ArrayList<BaseFragment> arrayList = new ArrayList<>();

        for(int i=0;i<tabStrings.size();i++) {
            arrayList.add(new LocalMusicViewPagerFragment(tabStrings.get(i),i));

        }
        return arrayList;

    }


    /**
     * 获取首页页面的Fragment集合
     * @param tabClasses 从网络解析出来TabClass集合
     * @return
     */
    public ArrayList<BaseFragment> getPager1ViewpagerFragments(List<TabClass> tabClasses) {
        if(viewpagerFragmentsPager1==null){
            viewpagerFragmentsPager1 = new ArrayList<>();

            int number = tabClasses.size()-1;

            for(int i=0;i<tabClasses.size();i++){
                switch (i){
                    case 16:
                    case 1:
                        viewpagerFragmentsPager1.add(new NewsWebViewpagerFragment(tabClasses.get(i).getUrl(),i));
                        break;
                    case 2:
                        viewpagerFragmentsPager1.add(new NewsZhiBoViewPagerFragment(tabClasses.get(i).getUrl(),i));
                        break;



                    default:
                        viewpagerFragmentsPager1.add(new NewsViewPagerFragment(tabClasses.get(i).getUrl(),i));
                }

            }
        }
        return viewpagerFragmentsPager1;
    }

    /**
     * 获取视频页面的Fragment集合
     */
    public ArrayList<BaseFragment> getPager2ViewpagerFragments() {
        if(viewpagerFragmentsPager2 == null){
            viewpagerFragmentsPager2 = new ArrayList<>();
            ArrayList<String> titles = getTabLayoutStringsPager2();
            for(int i=0;i<titles.size();i++){
                viewpagerFragmentsPager2.add(new VideoViewPagerFragment(Video.VIDEO_URL,i));
            }
        }
        return viewpagerFragmentsPager2;
    }

    //SharedPreferences存储
    public <T> void saveDataBySharedPreferencesUtil(Context context, String fileName, String biaoJi, T t){

        SharedPreferencesUtil.saveData(context,fileName,biaoJi,t);

    }

    //SharedPreferences读取
    public <T> T getDataBySharedPreferencesUtil(Context context, String fileName, String biaoJi,Class class1, T t){
        return  SharedPreferencesUtil.getData(context,fileName,biaoJi,class1,t);
    }

    public List<LocalRes> getLocalRess(String url){
        return ContentProviderUtils.getLocalRess(getContext(),url);
    }

    public void saveNewsDataToLocal(Context context, List<News.DataBean.ItemListBean> itemListBeans, List<News.DataBean.BigImgBean> bigImgBeans,int p){

        NewsSQLiteUtils.saveNewsData(context, itemListBeans, p, false);
        NewsSQLiteUtils.saveNewsBigItemData(context,bigImgBeans,p,false);

    }

    public List<News.DataBean.ItemListBean> getNewsData(int p){
        return NewsSQLiteUtils.getNewsData(getContext(),p);
    }

    public List<News.DataBean.BigImgBean> getNewsBigItemData(int p){
        return NewsSQLiteUtils.getNewsBigItemData(getContext(),p);
    }

}
