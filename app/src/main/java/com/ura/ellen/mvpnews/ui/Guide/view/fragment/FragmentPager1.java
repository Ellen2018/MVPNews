package com.ura.ellen.mvpnews.ui.Guide.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.Guide.view.GuideActivity;
import com.ura.ellen.mvpnews.ui.Splash.SplashActivity;
import com.ura.ellen.mvpnews.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class FragmentPager1 extends Fragment {


    @BindView(R.id.iv_gudie_pager)
    ImageView ivGudiePager;
    @BindView(R.id.tv_guide_pager3)
    TextView tvGuidePager3;
    Unbinder unbinder;
    private int p;

    public FragmentPager1(int p) {
        this.p = p;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_guide_pager1, null);
        unbinder = ButterKnife.bind(this, view);

        switch (p){

            case 0:

                break;

            case 1:

                break;

            case 2:

                ivGudiePager.setImageResource(R.drawable.guide_pager3);

                tvGuidePager3.setVisibility(View.VISIBLE);

                tvGuidePager3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesUtil.saveData(getActivity(),SharedPreferencesUtil.sharedPreference_appName,SharedPreferencesUtil.sharedPreference_first,true);

                        GuideActivity guideActivity = (GuideActivity) getActivity();
                        Intent intent = new Intent(getActivity(), SplashActivity.class);
                        getActivity().startActivity(intent);

                        guideActivity.finish1();

                    }
                });
                break;

        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
