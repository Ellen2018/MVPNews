package com.ura.ellen.mvpnews.MyView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.utils.ToastUtil;


/**
 * Created by lenovo on 2016/12/19.
 */

public class TitleBar extends LinearLayout implements View.OnClickListener{

    private View textViewSerach;
    //private View imageViewGame;
    private Context context;



    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    /**
     * 当布局文件加载完成的时候回调这个方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textViewSerach = getChildAt(1);
        //imageViewGame = getChildAt(2);

        textViewSerach.setOnClickListener(this);
        //imageViewGame.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_titlebar_serach:

                ToastUtil.toast(context,"搜索");

                break;

        }

    }
}
