package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 cms_channel
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
public class CmsChannelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //预留商城ID
    private String shopid;
    //父级ID
    private String parentid;
    //树路径
    private String path;
    //栏目名称
    private String name;
    //栏目类型
    private String type;
    //链接地址
    private String url;
    //打开方式
    private String target;
    //是否显示
    private Integer isshow;
    //是否禁用
    private Integer disabled;
    //排序字段
    private Integer location;
    //有子节点
    private Integer haschildren;
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
     * 设置：父级ID
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取：父级ID
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
     * 设置：栏目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：栏目名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：栏目类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：栏目类型
     */
    public String getType() {
        return type;
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
     * 设置：是否显示
     */
    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    /**
     * 获取：是否显示
     */
    public Integer getIsshow() {
        return isshow;
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
