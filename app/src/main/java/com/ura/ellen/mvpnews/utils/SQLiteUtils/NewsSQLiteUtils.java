package com.ura.ellen.mvpnews.utils.SQLiteUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ura.ellen.mvpnews.Mode.News;

import java.util.ArrayList;
import java.util.List;

public class NewsSQLiteUtils extends SQLiteOpenHelper{

    public static final String SQL_NAME = "MVPNews";

    public NewsSQLiteUtils(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static String getCreateSQLString_News(int p){

        return "create table news" + p + " ("
                + "id integer primary key autoincrement,"
                + "title text,"
                + "date text,"
                + "imagepath text,"
                + "url text)";

    }


    private static String getCreateSQLString_NewsLike(){

        return "create table newslike ("
                + "id integer primary key autoincrement,"
                + "title text,"
                + "date text,"
                + "imagepath text,"
                + "url text)";

    }

    private static String getCreateSQLString_NewsBigItem(int p){

        return "create table news_bigitem"+p+" ("
                + "id integer primary key autoincrement,"
                + "title text,"
                + "date text,"
                + "imagepath text,"
                + "url text)";

    }

    public static void saveNewsData(Context context,List<News.DataBean.ItemListBean> itemListBeans,int p,boolean isZhuiJia){

        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();

        if(!isZhuiJia) {

            db.execSQL("DROP TABLE news"+p+";");//删除此表
            db.execSQL(getCreateSQLString_News(p));//创建此表

        }


        ContentValues contentValues = new ContentValues();


        for(int i=0;itemListBeans!=null&&i<itemListBeans.size();i++){

            News.DataBean.ItemListBean itemListBean = itemListBeans.get(i);

            contentValues.put("title",itemListBean.getItemTitle());
            contentValues.put("date",itemListBean.getOperate_time());
            contentValues.put("imagepath",itemListBean.getItemImage().getImgUrl1());
            contentValues.put("url",itemListBean.getDetailUrl());
            db.insert("news"+p,null,contentValues);
            contentValues.clear();

        }

        db.close();



    }


    public static void saveUserLikeNewsData(Context context,String title,String date,String imagePath,String url){

        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();


            ContentValues contentValues = new ContentValues();
            contentValues.put("title",title);
            contentValues.put("date",date);
            contentValues.put("imagepath",imagePath);
            contentValues.put("url",url);
            db.insert("newslike",null,contentValues);
            contentValues.clear();
            db.close();
    }


    public static void deleteUserLikeNewsData(Context context,String url){

        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put("url",url);
        db.delete("newslike","url=?",new String[]{url});
        contentValues.clear();
        db.close();
    }


    public static boolean isUserLikeThisNewsData(Context context,String url){

        boolean isLike = false;
        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();

        Cursor cursor = db.query("newslike",null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            do{



                if(url.equals(cursor.getString(cursor.getColumnIndex("url")))){
                    isLike = true;
                    break;
                }

            }while(cursor.moveToNext());
        }


        db.close();

        return  isLike;
    }

    public static List<String[]> getUserLikeNewsData(Context context){

        List<String[]> lists = new ArrayList<>();


        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();

        Cursor cursor = db.query("newslike",null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            do{

                String[] strings = new String[4];

                strings[0] = cursor.getString(cursor.getColumnIndex("title"));
                strings[1] = cursor.getString(cursor.getColumnIndex("date"));
                strings[2] = cursor.getString(cursor.getColumnIndex("imagepath"));
                strings[3] = cursor.getString(cursor.getColumnIndex("url"));

                lists.add(strings);


            }while(cursor.moveToNext());
        }


        db.close();

        return  lists;
    }

    public static List<News.DataBean.ItemListBean> getNewsData(Context context,int p){

        List<News.DataBean.ItemListBean> lists = new ArrayList<>();

        NewsSQLiteUtils sqLiteUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqLiteUtil.getWritableDatabase();

        Cursor cursor = db.query("news"+p,null,null,null,null,null,null);

        if(cursor.moveToFirst()){

            do{


                News.DataBean.ItemListBean itemListBean = new News.DataBean.ItemListBean();
                itemListBean.setItemTitle(cursor.getString(cursor.getColumnIndex("title")));
                itemListBean.setOperate_time(cursor.getString(cursor.getColumnIndex("date")));
                News.DataBean.ItemListBean.ItemImageBean itemImageBean = new News.DataBean.ItemListBean.ItemImageBean();
                itemImageBean.setImgUrl1(cursor.getString(cursor.getColumnIndex("imagepath")));
                itemListBean.setItemImage(itemImageBean);
                itemListBean.setDetailUrl(cursor.getString(cursor.getColumnIndex("url")));

                lists.add(itemListBean);


            }while(cursor.moveToNext());

        }

        cursor.close();

        db.close();


        return lists;
    }


    public static void saveNewsBigItemData(Context context,List<News.DataBean.BigImgBean> bigImgBeans,int p,boolean isZhuiJia){

        NewsSQLiteUtils sqlUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqlUtil.getWritableDatabase();

        if(!isZhuiJia) {

            db.execSQL("DROP TABLE news_bigitem"+p+";");//删除此表
            db.execSQL(getCreateSQLString_NewsBigItem(p));//创建此表

        }


        ContentValues contentValues = new ContentValues();


        for(int i=0;bigImgBeans!=null&&i<bigImgBeans.size();i++){

            News.DataBean.BigImgBean bigImgBean = bigImgBeans.get(i);

            contentValues.put("title",bigImgBean.getItemTitle());
            contentValues.put("date",bigImgBean.getOperate_time());
            contentValues.put("imagepath",bigImgBean.getItemImage());
            contentValues.put("url",bigImgBean.getDetailUrl());
            db.insert("news_bigitem"+p,null,contentValues);
            contentValues.clear();

        }

        db.close();



    }

    public static List<News.DataBean.BigImgBean> getNewsBigItemData(Context context,int p){

        List<News.DataBean.BigImgBean> lists = new ArrayList<>();

        NewsSQLiteUtils sqLiteUtil = new NewsSQLiteUtils(context,SQL_NAME,null,1);

        SQLiteDatabase db = sqLiteUtil.getWritableDatabase();

        Cursor cursor = db.query("news_bigitem"+p,null,null,null,null,null,null);

        if(cursor.moveToFirst()){

            do{


                News.DataBean.BigImgBean bigImgBean = new News.DataBean.BigImgBean();
                bigImgBean.setItemTitle(cursor.getString(cursor.getColumnIndex("title")));
                bigImgBean.setOperate_time(cursor.getString(cursor.getColumnIndex("date")));
                bigImgBean.setItemImage(cursor.getString(cursor.getColumnIndex("imagepath")));
                bigImgBean.setDetailUrl(cursor.getString(cursor.getColumnIndex("url")));

                lists.add(bigImgBean);


            }while(cursor.moveToNext());

        }

        cursor.close();

        db.close();


        return lists;
    }

    public void saveNewsDataToLike(){

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //创建本地所有歌曲存放的数据库
        for(int i=0;i<16;i++) {
            sqLiteDatabase.execSQL(getCreateSQLString_News(i));
            sqLiteDatabase.execSQL(getCreateSQLString_NewsBigItem(i));
        }

        sqLiteDatabase.execSQL(getCreateSQLString_NewsLike());

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
