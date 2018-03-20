package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.VideoViewPagerFragment;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VideoPager extends BasePager {


    @BindView(R.id.stl_fragment_video)
    SmartTabLayout smartTabLayout;
    @BindView(R.id.vp_mainfragment_pager2)
    ViewPager vpMainfragmentPager2;

    /**
     * 记录用户主页面的子页面位置
     */
    private int p;


    public VideoPager(MainPresenter mainPresenter) {
        super(mainPresenter);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mainPresenter.mBaseMode.getContext()).inflate(R.layout.pager_video,null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void yeHua() {

        vpMainfragmentPager2.setBackgroundColor(Color.BLACK);
        smartTabLayout.setBackgroundColor(Color.BLACK);



    }

    @Override
    public void cancelYeHua() {
        vpMainfragmentPager2.setBackgroundColor(Color.WHITE);
        smartTabLayout.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void initData() {
        super.initData();

        //预加载
        vpMainfragmentPager2.setOffscreenPageLimit(mainPresenter.mBaseMode.getPager2ViewpagerFragments().size());

        //设置适配器

        vpMainfragmentPager2.setAdapter(new FragmentStatePagerAdapter(mainPresenter.mBaseMode.getFragmentActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mainPresenter.mBaseMode.getPager2ViewpagerFragments().get(position);
            }

            @Override
            public int getCount() {
                return mainPresenter.mBaseMode.getPager2ViewpagerFragments().size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mainPresenter.mBaseMode.getTabLayoutStringsPager2().get(position);
            }
        });

        vpMainfragmentPager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {


                p = position;
                userScorll(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //TabLayout绑定ViewPager
        smartTabLayout.setViewPager(vpMainfragmentPager2);


    }

    /**
     * 用户切换到其他主页面时调用
     */
    @Override
    public void changOnBackgroundAgo() {
        VideoViewPagerFragment  videoViewPagerFragment = (VideoViewPagerFragment) mainPresenter.getPager2Fragments().get(p);
        videoViewPagerFragment.stop();
    }

    /**
     * 更新页面的时候调用
     * @param json
     * @param what
     */
    public void upDataVideoData(String json,int what){
       mainPresenter.getPager2Fragments().get(p).upDateData(json,what);
    }

    /**
     * 当用户滑动页面事调用
     * @param position
     */
    private void userScorll(int position){
        VideoViewPagerFragment videoViewPagerFragment = (VideoViewPagerFragment) mainPresenter.mBaseMode.getPager2ViewpagerFragments().get(position);
        videoViewPagerFragment.upDateFromLocal();
    }

    /**
     * 用户第二次以后点击底部的对应的导航栏时调用
     */
    @Override
    public void onUpDate() {
        ToastUtil.toast(mainPresenter.mBaseMode.getContext(),"更新视频页面数据");
    }


}
