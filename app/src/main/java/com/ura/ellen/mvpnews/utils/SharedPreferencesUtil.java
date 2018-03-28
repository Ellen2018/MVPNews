package com.ura.ellen.mvpnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lenovo on 2018/1/20.
 */

public class SharedPreferencesUtil {


    /**
     *
     * @param context 上下文
     * @param biaoJi 存储标记
     * @param t 具体的值
     * @param <T>
     */

    public static String sharedPreference_appName = "MVPNews";
    public static String sharedPreference_isYeHua = "isYeHua";
    public static String sharedPreference_first = "isUserFirst";

    public static <T>   void  saveData(Context context, String fileName, String biaoJi, T t){

        SharedPreferences.Editor editor = context.getSharedPreferences(fileName,context.MODE_PRIVATE).edit();


        if(t instanceof Integer){
            editor.putInt(biaoJi,(Integer) t);
        }else if(t instanceof Boolean){
            editor.putBoolean(biaoJi,(Boolean) t);
        }else if(t instanceof String){
            editor.putString(biaoJi,(String)t);
        }else{
            new ToastUtil().toast(context,"SharedPreferencesUtil 存储异常：无法找到匹配类型");
        }

        editor.apply();//提交

    }


    /**
     *
     * @param context 上下文
     * @param biaoJi 键值对的键值
     * @param c 取值的对应的Class
     * @param t 默认值
     * @param <T>
     * @return
     */

    public static <T> T getData(Context context, String fileName, String biaoJi, Class c, T t){

        SharedPreferences spf = context.getSharedPreferences(fileName,context.MODE_PRIVATE);

        T t1 = null;

        if(c.getName().equals(Integer.class.getName())){
            t1 = (T)new Integer(spf.getInt(biaoJi,(Integer)t));
        }else if(c.getName().equals(Boolean.class.getName())){
            t1 = (T)new Boolean(spf.getBoolean(biaoJi,(Boolean) t));
        }else if(c.getName().equals(String.class.getName())){
            t1 = (T)new String(spf.getString(biaoJi,(String)t));
        }else {
            new ToastUtil().toast(context,"SharedPreferencesUtil 取值异常：无法找到匹配类型");
        }


        return t1;
    }

}
