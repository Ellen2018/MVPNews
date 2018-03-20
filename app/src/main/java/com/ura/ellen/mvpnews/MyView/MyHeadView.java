package com.ura.ellen.mvpnews.MyView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

import com.jwenfeng.library.pulltorefresh.view.HeadView;

public class MyHeadView extends FrameLayout implements HeadView {

    public MyHeadView(@NonNull Context context) {
        super(context);
    }

    @Override
    public void begin() {

    }

    @Override
    public void progress(float progress, float all) {

    }

    @Override
    public void finishing(float progress, float all) {

    }

    @Override
    public void loading() {

    }

    @Override
    public void normal() {

    }

    @Override
    public View getView() {
        return null;
    }
}
