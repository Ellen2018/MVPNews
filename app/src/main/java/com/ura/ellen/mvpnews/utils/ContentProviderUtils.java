package com.ura.ellen.mvpnews.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.ura.ellen.mvpnews.Mode.LocalRes;

import java.util.ArrayList;

public class ContentProviderUtils {

    public static ArrayList<LocalRes> getLocalRess(Context context,String url){
        ArrayList<LocalRes> arrayList = new ArrayList<>();
        Uri uri = null;
        for (int i=0;i<LocalRes.types.length;i++){
            if(url.equals(LocalRes.types[i])){
                uri = LocalRes.urls[i];
                break;
            }
        }

        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = null;
        String[] objs = null;

        String sort = null;


        if(url.equals("视频")) {

            objs = new String[]{

                    MediaStore.Video.Media.DISPLAY_NAME,//视频在SD卡中的名字
                    MediaStore.Video.Media.DURATION,//视频的时长
                    MediaStore.Video.Media.SIZE,//视频文件大小
                    MediaStore.Video.Media.DATA//视频的绝对路径

            };

            sort = MediaStore.Video.Media.DEFAULT_SORT_ORDER;
        }else if(url.equals("图片")){

            objs = new String[]{

                    MediaStore.Images.Media.DISPLAY_NAME,//图片在SD卡中的名字
                    MediaStore.Images.Media.SIZE,//图片的大小
                    MediaStore.Images.Media.DATA//图片的绝对路径

            };

            sort = MediaStore.Images.Media.DEFAULT_SORT_ORDER;

        }else if(url.equals("音乐")){

            objs = new String[]{

                    MediaStore.Audio.Media.TITLE,//视频在SD卡中的名字
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.ALBUM,
                    MediaStore.Audio.Media.DURATION,//视频的时长
                    MediaStore.Audio.Media.SIZE,//视频文件大小
                    MediaStore.Audio.Media.DATA,//视频的绝对路径
                    MediaStore.Audio.Media.ARTIST_ID,//视频文件大小
                    MediaStore.Audio.Media.ALBUM_ID//视频的绝对路径


            };

            sort = MediaStore.Audio.Media.DEFAULT_SORT_ORDER;

        }

        if(uri != null) {
            cursor = resolver.query(uri, objs, null, null,null);
        }

        if(cursor!=null) {
            while (cursor.moveToNext()) {

                LocalRes localRes = new LocalRes();

                if(url.equals("视频")){

                    String videoName = cursor.getString(0);//视频名字
                    localRes.setName(videoName);

                    long videoTimes = cursor.getLong(1);//视频时长
                    localRes.setTime(videoTimes);

                    long videoSize = cursor.getLong(2);//视频文件大小
                    localRes.setSize(videoSize);

                    String videoPath = cursor.getString(3);//视频绝对路径
                    localRes.setPath(videoPath);


                }else if(url.equals("图片")){

                    String ImageName = cursor.getString(0);//视频名字
                    localRes.setName(ImageName);

                    long imageSize = cursor.getLong(1);//视频文件大小
                    localRes.setSize(imageSize);

                    String imagePath = cursor.getString(2);//视频绝对路径
                    localRes.setPath(imagePath);

                }else if(url.endsWith("音乐")){

                    String musicName = cursor.getString(0);
                    localRes.setMusicName(musicName);

                    String singerName = cursor.getString(1);
                    localRes.setSingerName(singerName);

                    String zhuanJIName = cursor.getString(2);
                    localRes.setZhuanJiName(zhuanJIName);

                    long time = cursor.getLong(3);
                    localRes.setTime(time);

                    long size = cursor.getLong(4);
                    localRes.setSize(size);

                    String path = cursor.getString(5);
                    localRes.setPath(path);

                    int musicId = cursor.getInt(6);
                    localRes.setMusicId(musicId);

                    int zhuanJiId = cursor.getInt(7);
                    localRes.setZhuanJiId(zhuanJiId);
                }


                arrayList.add(localRes);

            }

            cursor.close();//释放cursor资源
        }



        return arrayList;
    }

}
