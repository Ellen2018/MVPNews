package com.ura.ellen.mvpnews.utils;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;

/**
 * Created by lenovo on 2017/12/19.
 */

public class BitMapUtil {


    private Uri sArtworkUri = Uri
            .parse("content://media/external/audio/albumart");

    /**
     * 获取本地视频的第一帧
     *
     * @param filePath
     * @return
     */
    public static Bitmap getLocalVideoThumbnail(String filePath) {
        Bitmap bitmap = null;
        //MediaMetadataRetriever 是android中定义好的一个类，提供了统一
        //的接口，用于从输入的媒体文件中取得帧和元数据；
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据文件路径获取缩略图
            retriever.setDataSource(filePath);
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }

    public Bitmap decodeSampleBitmapFromFile(String filePath, int requestWidth, int requestHeight, boolean inSampleSize) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath,options);

        if(inSampleSize) {

            options.inSampleSize = calculateInSampleSize(options, requestWidth, requestHeight);
            //Toast.makeText(MainActivity.mContext, "" + options.inSampleSize, Toast.LENGTH_SHORT).show();

        }else{

            options.inSampleSize = 1;

        }

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath,options);
    }


    public Bitmap decodeSampleBitmapFromResource(Resources res, int resId, int requestWidth, int requestHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, requestWidth, requestHeight);


        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res, resId, options);
    }

    private  int calculateInSampleSize(BitmapFactory.Options options, int requestWidth, int requestHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;

        int inSampleSize = 1;
        if (height > requestHeight || width > requestWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfWidth / inSampleSize) >= requestWidth && (halfHeight / inSampleSize) >= requestHeight) {
                inSampleSize = inSampleSize * 2;
            }
        }
        return inSampleSize;
    }

}
