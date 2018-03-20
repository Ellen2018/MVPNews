package com.ura.ellen.baselibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ura.ellen.baselibrary.presenter.BasePresenter;
import com.ura.ellen.baselibrary.presenter.view.BaseView;

import javax.inject.Inject;

public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {



    @Inject
    public T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
