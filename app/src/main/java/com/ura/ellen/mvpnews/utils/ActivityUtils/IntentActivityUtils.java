package com.ura.ellen.mvpnews.utils.ActivityUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.ura.ellen.mvpnews.R;
import com.ura.ellen.mvpnews.ui.LookNews.LookNewsActivity;

public class IntentActivityUtils {

    public static final String NEWS_TITLE = "news_title";
    public static final String NEWS_DATE = "news_date";
    public static final String NEWS_IMAGEPATH = "news_imagepath";
    public static final String NEWS_URL = "news_url";



    public static void jumpToNextActivity(Activity activity,Context context,Class class1){
        Intent intent = new Intent(context,class1);
        context.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }


    public static void jumpToLookNewsActivity(Activity activity,Context context,String title,String date,String imagePath,String url){
        Intent intent = new Intent(context, LookNewsActivity.class);
        intent.putExtra(NEWS_TITLE,title);
        intent.putExtra(NEWS_DATE,date);
        intent.putExtra(NEWS_IMAGEPATH,imagePath);
        intent.putExtra(NEWS_URL,url);

        context.startActivity(intent);

        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

}
