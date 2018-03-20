package com.ura.ellen.mvpnews.Mode;


import java.util.List;

public class NewsPagerTab {

    public static final String NEWS_URL = "http://m.news.cntv.cn/special/json/fl626/index.json";

    private List<TabClass> data;

    public List<TabClass> getData() {
        return data;
    }

    public void setData(List<TabClass> data) {
        this.data = data;
    }


}
