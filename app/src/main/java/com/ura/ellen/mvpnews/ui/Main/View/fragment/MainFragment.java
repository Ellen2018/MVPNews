package com.ura.ellen.mvpnews.ui.Main.View.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ura.ellen.baselibrary.ui.fragment.BaseFragment;
import com.ura.ellen.mvpnews.ui.Main.View.MainActivity;
import com.ura.ellen.mvpnews.ui.Main.View.fragment.MainPager.BasePager;
import com.ura.ellen.mvpnews.ui.Main.Presenter.MainPresenter;

@SuppressLint("ValidFragment")
public class MainFragment extends BaseFragment {

    private BasePager basePager;

    public  MainFragment(BasePager basePager){
        this.basePager = basePager;
    }


    @Override
    public void yeHua() {



    }

    @Override
    public void cancelYeHua() {

    }

    @Override
    public void autoRefresh() {

    }

    @Override
    public void upDateFromNetRefresh() {

    }

    @Override
    public void upDateFromLocal() {

    }

    @Override
    public void upDateFromNetLaodMore() {

    }

    @Override
    public void upDateData(String json, int what) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (basePager != null) {
            return  basePager.rootView;
        } else {
            return null;
        }
    }

}
