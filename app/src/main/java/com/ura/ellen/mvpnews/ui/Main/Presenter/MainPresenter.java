package com.ura.ellen.mvpnews.ui.Main.Presenter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.ura.ellen.baselibrary.presenter.BasePresenter;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.Mode.NewsPagerTab;
import com.ura.ellen.mvpnews.Mode.TabClass;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.Mode.Video;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Model.MainMode;
import com.ura.ellen.mvpnews.ui.Main.View.MainView;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView,MainMode> {

    @Inject
    public MainPresenter(){
    }


    public Context getContenxt(){
        return mBaseMode.getContext();
    }

    public FragmentActivity getActivity(){
        return mBaseMode.getFragmentActivity();
    }

    //底部切换页面时调用
    public void qieHuanPager(int pagerInt){

       // if(mBaseMode.getBasePager() instanceof VideoPager){return;}

        //这里有个问题就是视频页面切换到其他页面在回切回来时，视频页面的ListView无缘无故回到顶部

        //同时更新数据
        if(pagerInt == mBaseMode.getPagerInt()) {
            mBaseMode.getBasePager().onUpDate();
        }else{

            //切换之前做切换前动作
            if(mBaseMode.getBasePager()!=null) {
                mBaseMode.getBasePager().changOnBackgroundAgo();
            }

            mBaseMode.setBasePager(mBaseMode.getBasePagers(this).get(pagerInt));
            int isRight = 0;
            if(mBaseMode.getPagerInt()>pagerInt){
                isRight = -1;
            }else{
                isRight = 1;
            }

            if(mBaseMode.getPagerInt() == -1){isRight = 0;}

            mBaseView.qieHuanMainBootomPager(mBaseMode.getMainFragment(), R.id.fl_mainactivity,isRight);
            mBaseMode.setPagerInt(pagerInt);

        }
    }



    /**
     * 通过Mode层写入数据到SharedPreferences文件中
     * @param context
     * @param fileName
     * @param biaoJi
     * @param t
     * @param <T>
     */
    public <T> void saveDataBySharedPreferencesUtil(Context context, String fileName, String biaoJi, T t){
       mBaseMode.saveDataBySharedPreferencesUtil(context,fileName,biaoJi,t);

    }

    /**
     * 通过Mode层读取SharedPreferences文件中的数据
     * @param context
     * @param fileName
     * @param biaoJi
     * @param class1
     * @param t
     * @param <T>
     * @return
     */
    public <T> T getDataBySharedPreferencesUtil(Context context, String fileName, String biaoJi,Class class1, T t){
        return  mBaseMode.getDataBySharedPreferencesUtil(context,fileName,biaoJi,class1,t);
    }




    /**
     *
     * @return 返回页面1的ViewPager的Fragment数据
     */
    public ArrayList<BaseFragment> getPager1Fragments(List<TabClass> tabClasses){
        return mBaseMode.getPager1ViewpagerFragments(tabClasses);
    }

    /**
     *
     * @return 返回页面2的ViewPager的TabLaout数据
     */
    public ArrayList<String> getPager2Titles(){
        return mBaseMode.getTabLayoutStringsPager2();
    }

    /**
     *
     * @return 返回页面2的ViewPager的Fragment数据
     */
    public ArrayList<BaseFragment> getPager2Fragments(){
        return mBaseMode.getPager2ViewpagerFragments();
    }

    public void saveNewsTabData(final List<TabClass> tabClasses){
        new Thread(){

            @Override
            public void run() {
                mBaseMode.saveTabData(tabClasses);
            }
        }.start();
    }

    public List<TabClass> getNewsTabData(){

        return mBaseMode.getTabClass();
    }

    /**
     * 从网络请求视频数据时调用
     * @param url
     * @param what
     */
    public void requestVideoNetData(final String url, final int what){

        new Thread(){

            @Override
            public void run() {
                String netDataJson = null;
                try {
                    netDataJson = mBaseMode.requestNet(url);
                } catch (IOException e) {
                    if(e.getClass().equals(TimeoutException.class)){
                        //网络超时异常
                        netDataJson = null;
                    }
                }
                mBaseView.upDateVideoData(netDataJson,what);

            }
        }.start();

    }





    /**
     * 存储单条的视频数据到本地
     * @param trailersBean
     */
    public void saveVideoDataToLocal(TrailersBean trailersBean){

        mBaseMode.saveVideoDataToLocal(trailersBean);

    }

    /**
     * 存储多个视频数据到本地
     */
     public void saveVideoDatasToLocal(List<TrailersBean> lists){
         mBaseMode.saveVideoDatasToLocal(lists);
     }


    /**
     * 获取本地所有的视频数据
     * @return
     */
     public List<TrailersBean> getAllLocalVideoData(){
         return mBaseMode.getAllLocalVideoData();
     }

    /**
     * 清空数据库式存储
     */
    public void saveVideoDatasAndClearAllData(List<TrailersBean> lists){

        mBaseMode.saveVideoDatasAndClearAllData(lists);

    }


    /**
     * 加载首页新闻的标题类
     */
    public void requestNewsPagerTabData(){

        new Thread(){


            @Override
            public void run() {

                //是否本地已经保存了？
                String netDataJson = null;

                try {
                    netDataJson = mBaseMode.requestNet(NewsPagerTab.NEWS_URL);
                } catch (IOException e) {
                    if(e.getClass().equals(TimeoutException.class)){
                        netDataJson = null;
                    }
                }
                mBaseView.upDateNewsPagerTab(netDataJson);
            }





        }.start();

    }

    /**
     * 加载首页新闻的标题类
     */
    public void requestNewsData(final String url, final int p, final int what){

        new Thread(){


            @Override
            public void run() {

                String netDataJson = null;

                try {
                    netDataJson = mBaseMode.requestNet(url);
                } catch (IOException e) {
                    if(e.getClass().equals(TimeoutException.class)){
                        netDataJson = null;
                    }
                }
                mBaseView.upDateNewsData(p,netDataJson,what);

            }





        }.start();

    }

    public void getLocalRes(final String url, final int p, final int what){

        new Thread(){

            @Override
            public void run() {
                List<LocalRes> localRes = mBaseMode.getLocalRess(url);
                mBaseView.upDateLocalRes(localRes,p,what);
            }

        }.start();

    }

    public void getLocalNewsData(final int p, final int what){
        new Thread(){

            @Override
            public void run() {
               List<News.DataBean.ItemListBean> itemListBeans = mBaseMode.getNewsData(p);
               List<News.DataBean.BigImgBean> bigImgBeans = mBaseMode.getNewsBigItemData(p);
               mBaseView.upDateLocalNewsData(itemListBeans,bigImgBeans,p,what);
            }
        }.start();
    }

    public void saveNewsDataToLocal(Context context, List<News.DataBean.ItemListBean> itemListBeans, List<News.DataBean.BigImgBean> bigImgBeans,int p){
        mBaseMode.saveNewsDataToLocal(context,itemListBeans,bigImgBeans,p);
    }


    public void yeHua(){
       mBaseView.yeHua();
    }

    public void cancelYeHua(){
        mBaseView.cancelYeHua();
    }

}
