package com.ura.ellen.mvpnews.utils;

public class TimeUtils {

    public static String getUserCanKnowTimeString(int times){

        //获取分钟数目
        int minis = times/60;

        //获取秒数
        int miao = times - minis*60;

        String fenString = "";
        String miaoString = "";

        if(minis<10){
            fenString = "0"+minis;
        }else {
            fenString = minis+"";
        }

        if(miao<10){
            miaoString = "0"+miao;
        }else {
            miaoString = miao+"";
        }


        return fenString+" : "+miaoString;
    }

}
