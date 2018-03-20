package com.ura.ellen.mvpnews.utils;

import com.google.gson.Gson;
import com.ura.ellen.mvpnews.Mode.News;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.Mode.Video;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static List<TrailersBean> getListTrailersBeanFromJson(String json){

        List<TrailersBean> arrayList = new ArrayList<>();

        Gson gson = new Gson();
        Video video = gson.fromJson(json,Video.class);
        arrayList = video.getTrailers();

        return arrayList;

    }

    public static News.DataBean getDataBeanFronJson(String json) {
        Gson gson = new Gson();
        News news = gson.fromJson(json, News.class);
        List<News.DataBean.ItemListBean> itemListBeans = news.getData().getItemList();
        List<News.DataBean.BigImgBean> bigImgBeans = news.getData().getBigImg();

        for(int i=0;i<itemListBeans.size();i++){
            if(itemListBeans.get(i).getItemTitle().contains("请升级客户端到最新版")){
                itemListBeans.remove(i);
            }
        }

        for(int i=0;i<bigImgBeans.size();i++){
            if(bigImgBeans.get(i).getItemTitle().contains("请升级客户端到最新版")){
                bigImgBeans.remove(i);
            }
        }

        return news.getData();
    }

}
