package com.ura.ellen.mvpnews.utils.GreenDaoUtils;

import com.ura.ellen.mvpnews.BaseApplication;
import com.ura.ellen.mvpnews.Mode.TabClass;
import com.ura.ellen.mvpnews.Mode.TrailersBean;
import com.ura.ellen.mvpnews.Mode.TrailersBeanDao;

import java.util.List;

public class TabClassGreenUtils {

    /**
     * 存储本地数据
     */
    public void saveTabClassData(TabClass tabClass){

        BaseApplication.getDaoInstant().getTabClassDao().insert(tabClass);

    }

    /**
     * 删除数据,一般用作用户删除缓存
     *
     * @param id
     */
    public  void deleteVideoData(long id) {
        BaseApplication.getDaoInstant().getTabClassDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param tabClass
     */
    public  void updateLove(TabClass tabClass) {
        BaseApplication.getDaoInstant().getTabClassDao().update(tabClass);
    }


    /**
     * 查询全部数据
     */
    public List<TabClass> queryAll() {
        return BaseApplication.getDaoInstant().getTabClassDao().loadAll();
    }

    public void saveAllTabData(List<TabClass>tabClasses){
        for(TabClass tabClass:tabClasses){
            saveTabClassData(tabClass);
        }
    }

}
