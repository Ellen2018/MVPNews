package com.ura.ellen.mvpnews.Mode;

import android.net.Uri;
import android.provider.MediaStore;

public class LocalRes {

    public static String[] types = new String[]{"视频","图片","音乐"};
    public static Uri[] urls = new Uri[]{
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    };

    private String path = "";
    private String name = "";
    private long size = 0;
    private String type = types[0];
    private long time = 0;

    private String singerName = "未知";
    private String musicName = "未知";

    public String getZhuanJiName() {
        return zhuanJiName;
    }

    public void setZhuanJiName(String zhuanJiName) {
        this.zhuanJiName = zhuanJiName;
    }

    private String zhuanJiName = "未知";
    private int musicId = 0;
    private int ZhuanJiId = 0;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public int getZhuanJiId() {
        return ZhuanJiId;
    }

    public void setZhuanJiId(int zhuanJiId) {
        ZhuanJiId = zhuanJiId;
    }


}
