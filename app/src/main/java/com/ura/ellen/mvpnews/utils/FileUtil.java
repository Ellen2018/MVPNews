package com.ura.ellen.mvpnews.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2017/12/25.
 */

public class FileUtil {

    public File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");

    /**
     * 保存Bitmap到本地
     * @param bmp
     * @param filePath
     */
       public void saveImage(Bitmap bmp, String filePath) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = filePath + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将本地图片转化为Bitmap并且返回
     * @param filePath
     * @param inSampleSize
     * @return
     */
    public Bitmap getImageFromMusicClass(String filePath, boolean inSampleSize){

        Bitmap bitmap = null;

        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName =filePath + ".jpg";
        bitmap = new BitMapUtil().decodeSampleBitmapFromFile(new File(appDir,fileName).getAbsolutePath(),100,100,inSampleSize);

        return  bitmap;
    }



}
