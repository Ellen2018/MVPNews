package com.ura.ellen.baselibrary.presenter;

import com.ura.ellen.baselibrary.presenter.view.BaseView;

import javax.inject.Inject;

public class BasePresenter<T extends BaseView,E extends BaseMode> {

    public T mBaseView;
    public E mBaseMode;


}
