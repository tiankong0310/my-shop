package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_mass
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxMassEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //群发名称
    private String name;
    //群发类型
    private String type;
    //媒体文件ID
    private String mediaId;
    //Scope
    private String scope;
    //Content
    private String content;
    //发送状态
    private Integer status;
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
     * 设置：群发名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：群发名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：群发类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：群发类型
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：媒体文件ID
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 获取：媒体文件ID
     */
    public String getMediaId() {
        return mediaId;
    }
    /**
     * 设置：Scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取：Scope
     */
    public String getScope() {
        return scope;
    }
    /**
     * 设置：Content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：Content
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：发送状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：发送状态
     */
    public Integer getStatus() {
        return status;
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
