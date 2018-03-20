package com.ura.ellen.mvpnews.utils.NetUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp3的封装工具类
 */
public class MyOkHttpUtils {

    private Gson gson;
    private OkHttpClient okHttpClient;
    private static volatile MyOkHttpUtils myOkHttpUtils = null;

    private final  int READ_TIMEOUT = 3000,WRITE_TIMEOUT = 3000,CONNECT_TIMEOUT = 3000;



    private MyOkHttpUtils(){

        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
                .build();
        gson = new Gson();

    }

    /**
     * 单例模式
     * @return
     */
    public static MyOkHttpUtils getInstance(){
        if(myOkHttpUtils == null){
            synchronized (MyOkHttpUtils.class){
                if(myOkHttpUtils == null){
                    myOkHttpUtils = new MyOkHttpUtils();
                }
            }
        }
        return myOkHttpUtils;
    }

    public OkHttpClient get(){
        return okHttpClient;
    }

    public String getJson(String url) throws IOException {

        return     get().newCall(new Request.Builder()
                .url(url)
                .build()).execute().body().string();
    }



}
