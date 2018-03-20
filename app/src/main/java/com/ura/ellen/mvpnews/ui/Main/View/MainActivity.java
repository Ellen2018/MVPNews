package com.ura.ellen.mvpnews.ui.Main.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.TabSelectionInterceptor;
import com.ura.ellen.baselibrary.ui.activity.BaseMvpActivity;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Model.MainMode;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.LocalPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.NewsPager;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.VideoPager;
import com.ura.ellen.mvpnews.utils.ActivityUtils.ActivityManager;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView {


    @BindView(R.id.fl_mainactivity)
    FrameLayout flMainactivity;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
//    @BindView(R.id.tv_yehua)
//    TextView yeHua;

    private int[] bootoBatTapId = new int[]{R.id.tab_news,R.id.tab_video,R.id.tab_local,R.id.tab_user};

    private BottomBarOnTabReselectListener bottomBarOnTabReselectListener;
    private BottomOnTabSelectListener bottomOnTabSelectListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置去除ActionBar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置去除ActionBar
        //getSupportActionBar().hide();
        //设置全屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //取出全屏
        //this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //实例化P层
        mPresenter = new MainPresenter();
        //实例化Mode层
        mPresenter.mBaseMode = new MainMode();
        mPresenter.mBaseMode.setContext(this);
        mPresenter.mBaseMode.setFragmentActivity(this);
        //实例化View层
        mPresenter.mBaseView = this;
        //这里的实例化可以通过框架自动进行实例化

        ActivityManager.mActivityManager.addActivity(this);

        //mPresenter.qieHuanPager(0);

        bottomBar.setOnTabSelectListener(bottomOnTabSelectListener = new BottomOnTabSelectListener());

        bottomBar.setOnTabReselectListener(bottomBarOnTabReselectListener = new BottomBarOnTabReselectListener());


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {

        ActivityManager.mActivityManager.removeActivity(this);
        SharedPreferencesUtil.saveData(MainActivity.this,SharedPreferencesUtil.sharedPreference_appName,SharedPreferencesUtil.sharedPreference_isYeHua,false);
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }


        super.onBackPressed();

    }

    @Override
    public void qieHuanMainBootomPager(Fragment fragment, int id,int value) {

        replaceFragment(fragment, id,value);

    }


    /**
     * 更新视频页面数据
     */
    @Override
    public void upDateVideoData(String json, int what) {
        VideoPager videoPager = (VideoPager) mPresenter.mBaseMode.getBasePager();
        videoPager.upDataVideoData(json, what);

    }

    @Override
    public void upDateNewsPagerTab(String json) {
        NewsPager newsPager = (NewsPager) mPresenter.mBaseMode.getBasePager();
        newsPager.upDateTabData(json);

    }

    @Override
    public void upDateNewsData(int p, String json, int what) {
        NewsPager newsPager = (NewsPager) mPresenter.mBaseMode.getBasePagers(mPresenter).get(0);
        newsPager.upDateNewsData(p, json, what);

    }

    @Override
    public void upDateLocalRes(List<LocalRes> localRes, int p, int what) {
        LocalPager localPager = (LocalPager) mPresenter.mBaseMode.getBasePager();
        localPager.upDateLocalRes(localRes,p,what);
    }

    public void replaceFragment(Fragment fragment, int id,int value) {
        FragmentManager manager = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(value>0) {
            transaction.setCustomAnimations(
                    R.anim.in_from_right,
                    R.anim.out_to_left);
        }else if(value<0){
            transaction.setCustomAnimations(
                    R.anim.in_from_left,
                    R.anim.out_to_right);
        }
        transaction.replace(id, fragment);

        transaction.commit();
    }


    @Override
    public void yeHua() {

        bottomBar.setOnTabReselectListener(null);

        mPresenter.mBaseMode.saveDataBySharedPreferencesUtil
                (MainActivity.this, SharedPreferencesUtil.sharedPreference_appName,SharedPreferencesUtil.sharedPreference_isYeHua,true);
        //yeHua.setVisibility(View.VISIBLE);
        for(int i=0;i<mPresenter.mBaseMode.getBasePagers(mPresenter).size();i++) {
            bottomBar.getTabWithId(bootoBatTapId[i]).setBarColorWhenSelected(Color.BLACK);
            bottomBar.setDefaultTab(bootoBatTapId[0]);
            //bottomBar.setDefaultTab(bootoBatTapId[3]);
            mPresenter.mBaseMode.getBasePagers(mPresenter).get(i).yeHua();
        }

        mPresenter.mBaseMode.getMainFragment().yeHua();

        bottomBar.setOnTabReselectListener(bottomBarOnTabReselectListener);

    }

    @Override
    public void cancelYeHua() {
        bottomBar.setOnTabReselectListener(null);

        mPresenter.mBaseMode.saveDataBySharedPreferencesUtil
                (MainActivity.this, SharedPreferencesUtil.sharedPreference_appName,SharedPreferencesUtil.sharedPreference_isYeHua,false);
        //yeHua.setVisibility(View.VISIBLE);
        for(int i=0;i<mPresenter.mBaseMode.getBasePagers(mPresenter).size();i++) {
            bottomBar.getTabWithId(bootoBatTapId[i]).setBarColorWhenSelected(Color.WHITE);
            bottomBar.setDefaultTab(bootoBatTapId[0]);
            //bottomBar.setDefaultTab(bootoBatTapId[3]);
            mPresenter.mBaseMode.getBasePagers(mPresenter).get(i).cancelYeHua();
        }

        mPresenter.mBaseMode.getMainFragment().cancelYeHua();

        bottomBar.setOnTabReselectListener(bottomBarOnTabReselectListener);
    }

    @Override
    public void upDateLocalNewsData(List<News.DataBean.ItemListBean> itemListBeans,List<News.DataBean.BigImgBean> bigImgBeans, int p, int what) {
        NewsPager newsPager = (NewsPager) mPresenter.mBaseMode.getBasePagers(mPresenter).get(0);
        newsPager.upDateLocalNewsData(itemListBeans,bigImgBeans,p,what);

    }

    class BottomBarOnTabReselectListener implements OnTabReselectListener{
        @Override
        public void onTabReSelected(int tabId) {
            switch (tabId) {
                case R.id.tab_news:

                    mPresenter.qieHuanPager(0);

                    break;
                case R.id.tab_video:

                    mPresenter.qieHuanPager(1);

                    break;
                case R.id.tab_local:

                    mPresenter.qieHuanPager(2);

                    break;
                case R.id.tab_user:

                    mPresenter.qieHuanPager(3);

                    break;
            }

        }
    }

    class BottomOnTabSelectListener implements OnTabSelectListener{
        @Override
        public void onTabSelected(int tabId) {
            switch (tabId) {
                case R.id.tab_news:

                    mPresenter.qieHuanPager(0);

                    break;
                case R.id.tab_video:

                    mPresenter.qieHuanPager(1);

                    break;
                case R.id.tab_local:

                    mPresenter.qieHuanPager(2);

                    break;
                case R.id.tab_user:

                    mPresenter.qieHuanPager(3);

                    break;
            }
        }
    }


}
