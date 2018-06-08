package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_menu
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //父ID
    private String parentid;
    //树路径
    private String path;
    //菜单名称
    private String menuname;
    //菜单类型
    private String menutype;
    //关键词
    private String menukey;
    //网址
    private String url;
    //小程序appid
    private String appid;
    //小程序入口页
    private String pagepath;
    //排序字段
    private Integer location;
    //有子节点
    private Integer haschildren;
    //微信ID
    private String wxid;
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
     * 设置：父ID
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取：父ID
     */
    public String getParentid() {
        return parentid;
    }
    /**
     * 设置：树路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取：树路径
     */
    public String getPath() {
        return path;
    }
    /**
     * 设置：菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取：菜单名称
     */
    public String getMenuname() {
        return menuname;
    }
    /**
     * 设置：菜单类型
     */
    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    /**
     * 获取：菜单类型
     */
    public String getMenutype() {
        return menutype;
    }
    /**
     * 设置：关键词
     */
    public void setMenukey(String menukey) {
        this.menukey = menukey;
    }

    /**
     * 获取：关键词
     */
    public String getMenukey() {
        return menukey;
    }
    /**
     * 设置：网址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：网址
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：小程序appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * 获取：小程序appid
     */
    public String getAppid() {
        return appid;
    }
    /**
     * 设置：小程序入口页
     */
    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    /**
     * 获取：小程序入口页
     */
    public String getPagepath() {
        return pagepath;
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
     * 设置：有子节点
     */
    public void setHaschildren(Integer haschildren) {
        this.haschildren = haschildren;
    }

    /**
     * 获取：有子节点
     */
    public Integer getHaschildren() {
        return haschildren;
    }
    /**
     * 设置：微信ID
     */
    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    /**
     * 获取：微信ID
     */
    public String getWxid() {
        return wxid;
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
