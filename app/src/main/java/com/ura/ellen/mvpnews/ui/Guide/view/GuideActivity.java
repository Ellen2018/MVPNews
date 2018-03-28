package com.ura.ellen.mvpnews.ui.Guide.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Guide.view.fragment.FragmentPager1;
import com.ura.ellen.mvpnews.ui.Splash.SplashActivity;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends FragmentActivity {


    @BindView(R.id.vp_guideavtivity)
    ViewPager vpGuideActivity;
    @BindView(R.id.dot_first)
    ImageView dotFirst;
    @BindView(R.id.dot_second)
    ImageView dotSecond;
    @BindView(R.id.dot_thrid)
    ImageView dotThrid;

    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        if(SharedPreferencesUtil.getData(GuideActivity.this,SharedPreferencesUtil.sharedPreference_appName,SharedPreferencesUtil.sharedPreference_first
        ,Boolean.class,false)){
            Intent intent = new Intent(GuideActivity.this, SplashActivity.class);
            startActivity(intent);
            finish1();
        }

        fragments.add(new FragmentPager1(0));
        fragments.add(new FragmentPager1(1));
        fragments.add(new FragmentPager1(2));


        vpGuideActivity.setAdapter(new FragmentPagerAdapter(GuideActivity.this.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


        vpGuideActivity.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {



                switch (position){

                    case 0:
                        dotFirst.setImageResource(R.drawable.dot_normal);
                        dotSecond.setImageResource(R.drawable.dot);
                        dotThrid.setImageResource(R.drawable.dot);
                        break;

                    case 1:
                        dotFirst.setImageResource(R.drawable.dot);
                        dotSecond.setImageResource(R.drawable.dot_normal);
                        dotThrid.setImageResource(R.drawable.dot);
                        break;
                    case 2:
                        dotFirst.setImageResource(R.drawable.dot);
                        dotSecond.setImageResource(R.drawable.dot);
                        dotThrid.setImageResource(R.drawable.dot_normal);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public void finish1(){
        finish();
    }

}
