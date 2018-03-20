package com.ura.ellen.mvpnews.Mode;

import java.util.List;

public class Video  {


    /**
     * 网络视频的联网地址
     */
    public static  final  String VIDEO_URL = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";


    private List<TrailersBean> trailers;

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }


}
