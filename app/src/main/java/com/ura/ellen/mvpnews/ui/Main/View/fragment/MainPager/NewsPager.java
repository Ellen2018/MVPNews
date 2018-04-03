package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.Mode.NewsPagerTab;
import com.ura.ellen.mvpnews.Mode.TabClass;
import com.ura.ellen.mvpnews.MyView.TitleBar;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.NewsViewPagerFragment;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.NewsZhiBoViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsPager extends BasePager {

    private SmartTabLayout smartTabLayout;
    private ViewPager vpMainfragmentPager1;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private TitleBar titleBar;

    private ArrayList<BaseFragment> viewPagerFragments;

    private Context context;
    private FragmentActivity activity;

    private int p = 0;//记录首页页面的位置

    private MyHandler myHandler;

    private List<TabClass> tabClasses;

    private final  int UPDATE_TAB = 0;
    private long startTime = 0;




    public NewsPager(MainPresenter mainPresenter) {
        super(mainPresenter);
        context = mainPresenter.getContenxt();
        activity = mainPresenter.getActivity();
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mainPresenter.mBaseMode.getContext()).inflate(R.layout.pager_shouye, null);

        myHandler = new MyHandler();

        smartTabLayout = view.findViewById(R.id.stl_fragment_news);
        vpMainfragmentPager1 = view.findViewById(R.id.vp_mainfragment_pager1);
        titleBar = view.findViewById(R.id.titlebar);


        vpMainfragmentPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                p = position;
                viewPagerFragments.get(p).upDateFromLocal();


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        return view;
    }

    @Override
    public void yeHua() {

        vpMainfragmentPager1.setBackgroundColor(Color.BLACK);
        smartTabLayout.setBackgroundColor(Color.BLACK);
        titleBar.setBackgroundColor(Color.BLACK);

        for(BaseFragment baseFragment:viewPagerFragments){
            baseFragment.yeHua();
        }

    }


    public void hideToolBar(){
//        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
//                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                -1.0f);
//        mHiddenAction.setDuration(500);
//        titleBar.setAnimation(mHiddenAction);
        titleBar.setVisibility(View.GONE);
    }

    public void showToolBar(){
//        TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
//        mShowAction.setDuration(500);
//        titleBar.setAnimation(mShowAction);
        titleBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void cancelYeHua() {
        vpMainfragmentPager1.setBackgroundColor(Color.WHITE);
        smartTabLayout.setBackgroundColor(Color.WHITE);
        titleBar.setBackgroundColor(Color.parseColor("#ff3097fd"));

        for(BaseFragment baseFragment:viewPagerFragments){
            baseFragment.cancelYeHua();
        }
    }


    public void updateTabLayout(){
        myFragmentPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUpDate() {

         mainPresenter.mBaseMode.getPager1ViewpagerFragments(tabClasses).get(p).autoRefresh();

    }

    @Override
    public void initData() {
        super.initData();
        //请求数据
        tabClasses = mainPresenter.getNewsTabData();
        if(tabClasses == null||tabClasses.size()==0) {
            mainPresenter.requestNewsPagerTabData();
        }else{
            myHandler.sendEmptyMessage(UPDATE_TAB);
        }

    }

    @Override
    public void changOnBackgroundAgo() {

    }

    private static class MyFragmentPagerAdapter extends FragmentStatePagerAdapter{

        private MainPresenter mainPresenter;

        private ArrayList<BaseFragment> fragments;
        private List<TabClass> tabClasses;

        public MyFragmentPagerAdapter(MainPresenter mainPresenter,FragmentManager fragmentManager,
                                      ArrayList<BaseFragment> arrayListFragments,List<TabClass> tabClasses){
            super(fragmentManager);
            this.mainPresenter = mainPresenter;
            this.fragments = arrayListFragments;
            this.tabClasses = tabClasses;
        }


        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return tabClasses.size();
        }

        //设置标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tabClasses.get(position).getTitle();
        }
    }


    private List<TabClass> jieXiTabData(String json){

        Gson gson = new Gson();
        NewsPagerTab news = gson.fromJson(json,NewsPagerTab.class);

        return news.getData();

    }

    /**
     * 更新Tab的,但是这个方法运行子线程
     * @param json
     */
    public void upDateTabData(String json){

        if(json!=null)
        tabClasses = jieXiTabData(json);

        if(tabClasses!=null){
            mainPresenter.saveNewsTabData(tabClasses);
        }
        myHandler.sendEmptyMessage(UPDATE_TAB);

    }

    /**
     * 更新对应页面的新闻数据，比如：要闻
     */
    public void upDateNewsData(int p,String json,int what){
        viewPagerFragments.get(p).upDateData(json,what);
    }

    public void upDateLocalNewsData(List<News.DataBean.ItemListBean> itemListBeans,List<News.DataBean.BigImgBean> bigImgBeans,int p,int what){

        if(p == 2){
            ((NewsZhiBoViewPagerFragment)viewPagerFragments.get(p)).upDateDataLocal(itemListBeans,null,what);
            return;
        }
        ((NewsViewPagerFragment)viewPagerFragments.get(p)).upDateDataLocal(itemListBeans,bigImgBeans,what);

    }

    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){

                case UPDATE_TAB:

                    //更新

                    //预加载
                    vpMainfragmentPager1.setOffscreenPageLimit(tabClasses.size());
                    viewPagerFragments = mainPresenter.getPager1Fragments(tabClasses);
                    myFragmentPagerAdapter = new MyFragmentPagerAdapter(mainPresenter,activity.getSupportFragmentManager(),viewPagerFragments,tabClasses);
                    vpMainfragmentPager1.setAdapter(myFragmentPagerAdapter);
                    //tlMainfragmentPager1.setTabTextColors(Color.BLACK,Color.RED);


                     //TabLayout绑定ViewPager
                    smartTabLayout.setViewPager(vpMainfragmentPager1);


                    break;

            }
        }
    }

}
