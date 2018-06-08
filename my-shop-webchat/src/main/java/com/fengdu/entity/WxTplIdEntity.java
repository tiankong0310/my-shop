package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_tpl_id
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
public class WxTplIdEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //模板编号
    private String id;
    //模板ID
    private String templateId;
    //微信ID
    private String wxid;
    //操作人
    private String opby;
    //操作时间
    private Integer opat;
    //删除标记
    private Integer delflag;

    /**
     * 设置：模板编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：模板编号
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取：模板ID
     */
    public String getTemplateId() {
        return templateId;
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
