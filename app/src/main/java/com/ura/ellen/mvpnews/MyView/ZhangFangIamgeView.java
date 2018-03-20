package com.ura.ellen.mvpnews.MyView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lenovo on 2018/2/11.
 */

@SuppressLint("AppCompatCustomView")
public class ZhangFangIamgeView extends ImageView {
    public ZhangFangIamgeView(Context context) {
        super(context);
    }

    public ZhangFangIamgeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZhangFangIamgeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //传入参数widthMeasureSpec、heightMeasureSpec
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}
