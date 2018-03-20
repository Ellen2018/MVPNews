package com.ura.ellen.mvpnews.utils.ActivityUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.ura.ellen.mvpnews.R;

public class ActivityIntentUtils {

    public static void jumpToNextActivityNoAnim(Context context, Class class1){
        Intent intent = new Intent(context,class1);
        context.startActivity(intent);

    }

}
