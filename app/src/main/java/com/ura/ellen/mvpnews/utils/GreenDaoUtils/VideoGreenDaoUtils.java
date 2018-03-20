package com.ura.ellen.mvpnews.utils.GreenDaoUtils;

import com.ura.ellen.mvpnews.BaseApplication;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.Mode.TrailersBeanDao;

import java.util.List;

public class VideoGreenDaoUtils {

    /**
     * 存储本地数据
     */
    public void saveVideoData(TrailersBean trailersBean){

        BaseApplication.getDaoInstant().getTrailersBeanDao().insert(trailersBean);

    }

    /**
     * 删除数据,一般用作用户删除缓存
     *
     * @param id
     */
    public  void deleteVideoData(long id) {
        BaseApplication.getDaoInstant().getTrailersBeanDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param trailersBean
     */
    public  void updateLove(TrailersBean trailersBean) {
        BaseApplication.getDaoInstant().getTrailersBeanDao().update(trailersBean);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public List<TrailersBean> queryLove() {
        return BaseApplication.getDaoInstant().getTrailersBeanDao().queryBuilder().
                where(TrailersBeanDao.Properties.MovieName.eq(TrailersBeanDao.TABLENAME)).list();
    }


    public void deleteVideoAllData(){
        List<TrailersBean> list =queryAll();
        for(int i=0;i<list.size();i++){
            deleteVideoData(list.get(i).getID());
        }
    }

    /**
     * 查询全部数据
     */
    public  List<TrailersBean> queryAll() {
        return BaseApplication.getDaoInstant().getTrailersBeanDao().loadAll();
    }


    /**
     * 保存一个TrailersBean集合数据，保存之前去除所有数据
     * @param lists
     */
    public void saveVideoDatasAndClearAllData(List<TrailersBean> lists){
        this.deleteVideoAllData();
        saveVideoDatasToLocal(lists);
    }

    /**
     * 保存单条的Video数据到数据库
     * @param trailersBean
     */
    public void saveVideoDataToLocal(TrailersBean trailersBean){
        this.saveVideoData(trailersBean);
    }

    public void saveVideoDatasToLocal(List<TrailersBean> lists){
        for (int i=0;i<lists.size();i++){
            saveVideoDataToLocal(lists.get(i));
        }
    }

    public List<TrailersBean> getAllLocalVideoData(){
        return this.queryAll();
    }

}
