package com.ura.ellen.mvpnews.MyView;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JZVideoPlayerStandard;

public class MyJiaoZiPlayer extends JZVideoPlayerStandard
{
    public MyJiaoZiPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        SAVE_PROGRESS = false;//设置为不保存当前进度
    }

//    public MyJiaoZiPlayer(Context context) {
//        super(context);
//
//    }




}
