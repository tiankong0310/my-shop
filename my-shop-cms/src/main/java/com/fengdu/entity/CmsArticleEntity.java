package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 cms_article
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
public class CmsArticleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //预留商城ID
    private String shopid;
    //文章标题
    private String title;
    //文章简介
    private String info;
    //文章作者
    private String author;
    //标题图
    private String picurl;
    //文章内容
    private String content;
    //是否禁用
    private Integer disabled;
    //发布时间
    private Integer publishat;
    //排序字段
    private Integer location;
    //
    private String channelid;
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
     * 设置：预留商城ID
     */
    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取：预留商城ID
     */
    public String getShopid() {
        return shopid;
    }
    /**
     * 设置：文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：文章标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：文章简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取：文章简介
     */
    public String getInfo() {
        return info;
    }
    /**
     * 设置：文章作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取：文章作者
     */
    public String getAuthor() {
        return author;
    }
    /**
     * 设置：标题图
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 获取：标题图
     */
    public String getPicurl() {
        return picurl;
    }
    /**
     * 设置：文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：文章内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：是否禁用
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取：是否禁用
     */
    public Integer getDisabled() {
        return disabled;
    }
    /**
     * 设置：发布时间
     */
    public void setPublishat(Integer publishat) {
        this.publishat = publishat;
    }

    /**
     * 获取：发布时间
     */
    public Integer getPublishat() {
        return publishat;
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
     * 设置：
     */
    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    /**
     * 获取：
     */
    public String getChannelid() {
        return channelid;
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
