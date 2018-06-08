package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 cms_link
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
public class CmsLinkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //链接名称
    private String name;
    //链接类型
    private String type;
    //图片地址
    private String picurl;
    //链接地址
    private String url;
    //打开方式
    private String target;
    //
    private String classid;
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
     * 设置：链接名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：链接名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：链接类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：链接类型
     */
    public String getType() {
        return type;
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
     * 设置：链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：链接地址
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：打开方式
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取：打开方式
     */
    public String getTarget() {
        return target;
    }
    /**
     * 设置：
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }

    /**
     * 获取：
     */
    public String getClassid() {
        return classid;
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
