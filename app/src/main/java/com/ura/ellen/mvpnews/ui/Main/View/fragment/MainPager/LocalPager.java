package com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.Mode.LocalRes;
import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.ViewPagerFragment.LocalMusicViewPagerFragment;
import com.ura.ellen.mvpnews.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalPager extends BasePager {


    @BindView(R.id.stl_fragment_local)
    SmartTabLayout stlFragmentLocal;
    @BindView(R.id.vp_mainfragment_pager1)
    ViewPager vpMainfragmentPager1;

    private ArrayList<String> tabString;
    private ArrayList<BaseFragment> baseFragments;

    public LocalPager(MainPresenter mainPresenter) {
        super(mainPresenter);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mainPresenter.mBaseMode.getContext()).inflate(R.layout.pager_three, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void yeHua() {

        vpMainfragmentPager1.setBackgroundColor(Color.BLACK);
        stlFragmentLocal.setBackgroundColor(Color.BLACK);
        if(baseFragments!=null) {
            for (BaseFragment baseFragment : baseFragments) {
                baseFragment.yeHua();
            }
        }
    }

    @Override
    public void cancelYeHua() {
        vpMainfragmentPager1.setBackgroundColor(Color.WHITE);
        stlFragmentLocal.setBackgroundColor(Color.WHITE);
        if(baseFragments!=null) {
            for (BaseFragment baseFragment : baseFragments) {
                baseFragment.cancelYeHua();;
            }
        }
    }

    @Override
    public void initData() {
        super.initData();

        tabString = mainPresenter.mBaseMode.getTabLayoutStringsPager3();
        baseFragments = mainPresenter.mBaseMode.getTabLayoutStringsPager3(tabString);

        vpMainfragmentPager1.setAdapter(new FragmentStatePagerAdapter(mainPresenter.getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return baseFragments.get(position);
            }

            @Override
            public int getCount() {
                return baseFragments.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return tabString.get(position);
            }

        });

        stlFragmentLocal.setViewPager(vpMainfragmentPager1);

        vpMainfragmentPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                baseFragments.get(position).autoRefresh();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void onUpDate() {
        ToastUtil.toast(mainPresenter.mBaseMode.getContext(), "更新第三页数据");
    }

    @Override
    public void changOnBackgroundAgo() {

    }

    public void upDateLocalRes(List<LocalRes>localRes,int p,int what){

       LocalMusicViewPagerFragment localMusicViewPagerFragment = (LocalMusicViewPagerFragment) baseFragments.get(p);
       localMusicViewPagerFragment.upDateData(localRes,what);

    }

}
