package com.ura.ellen.mvpnews.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static void toast(Context context,String toastString){
        Toast.makeText(context,toastString,Toast.LENGTH_SHORT).show();
    }

}
