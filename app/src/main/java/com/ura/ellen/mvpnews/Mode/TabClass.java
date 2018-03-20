package com.ura.ellen.mvpnews.Mode;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class  TabClass {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * title : 要闻
     * identify : Nav-9Nwml0dIB6wAxgd9EfZA160510
     * url : http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataInfoNew?n2=20&id=Nav-9Nwml0dIB6wAxgd9EfZA160510&n1=3&version=1
     * isShow : 1
     * iosImgUrl : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2014/3/17/1395024170876_519.png
     * androidImgUrl : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2014/3/17/1395024311351_411.png
     * itemType : news_flag
     * sort :
     * specialSort :
     * order : 1
     */

    //不能用int
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String identify;
    private String url;
    private String isShow;
    private String iosImgUrl;
    private String androidImgUrl;
    private String itemType;
    private String sort;
    private String specialSort;
    private String order;

    @Generated(hash = 575174785)
    public TabClass(Long id, String title, String identify, String url, String isShow, String iosImgUrl, String androidImgUrl, String itemType,
            String sort, String specialSort, String order) {
        this.id = id;
        this.title = title;
        this.identify = identify;
        this.url = url;
        this.isShow = isShow;
        this.iosImgUrl = iosImgUrl;
        this.androidImgUrl = androidImgUrl;
        this.itemType = itemType;
        this.sort = sort;
        this.specialSort = specialSort;
        this.order = order;
    }

    @Generated(hash = 376538096)
    public TabClass() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIosImgUrl() {
        return iosImgUrl;
    }

    public void setIosImgUrl(String iosImgUrl) {
        this.iosImgUrl = iosImgUrl;
    }

    public String getAndroidImgUrl() {
        return androidImgUrl;
    }

    public void setAndroidImgUrl(String androidImgUrl) {
        this.androidImgUrl = androidImgUrl;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSpecialSort() {
        return specialSort;
    }

    public void setSpecialSort(String specialSort) {
        this.specialSort = specialSort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
