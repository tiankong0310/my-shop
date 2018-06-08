package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_reply_news
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxReplyNewsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //标题
    private String title;
    //摘要
    private String description;
    //图片地址
    private String picurl;
    //文章路径
    private String url;
    //排序字段
    private Integer location;
    //操作人
    private String opby;
    //操作时间
    private Integer opat;
    //删除标记
    private Integer delflag;

    /**
     * 设置：ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：ID
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：摘要
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：摘要
     */
    public String getDescription() {
        return description;
    }
    /**
     * 设置：图片地址
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 获取：图片地址
     */
    public String getPicurl() {
        return picurl;
    }
    /**
     * 设置：文章路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：文章路径
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：排序字段
     */
    public void setLocation(Integer location) {
        this.location = location;
    }

    /**
     * 获取：排序字段
     */
    public Integer getLocation() {
        return location;
    }
    /**
     * 设置：操作人
     */
    public void setOpby(String opby) {
        this.opby = opby;
    }

    /**
     * 获取：操作人
     */
    public String getOpby() {
        return opby;
    }
    /**
     * 设置：操作时间
     */
    public void setOpat(Integer opat) {
        this.opat = opat;
    }

    /**
     * 获取：操作时间
     */
    public Integer getOpat() {
        return opat;
    }
    /**
     * 设置：删除标记
     */
    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    /**
     * 获取：删除标记
     */
    public Integer getDelflag() {
        return delflag;
    }
}
