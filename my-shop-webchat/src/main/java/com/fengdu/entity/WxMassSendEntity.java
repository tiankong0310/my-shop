package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_mass_send
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxMassSendEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //群发ID
    private String massid;
    //Openid列表
    private String receivers;
    //发送状态
    private Integer status;
    //msgId
    private String msgid;
    //errCode
    private String errcode;
    //errMsg
    private String errmsg;
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
     * 设置：群发ID
     */
    public void setMassid(String massid) {
        this.massid = massid;
    }

    /**
     * 获取：群发ID
     */
    public String getMassid() {
        return massid;
    }
    /**
     * 设置：Openid列表
     */
    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }

    /**
     * 获取：Openid列表
     */
    public String getReceivers() {
        return receivers;
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
     * 设置：msgId
     */
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    /**
     * 获取：msgId
     */
    public String getMsgid() {
        return msgid;
    }
    /**
     * 设置：errCode
     */
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    /**
     * 获取：errCode
     */
    public String getErrcode() {
        return errcode;
    }
    /**
     * 设置：errMsg
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 获取：errMsg
     */
    public String getErrmsg() {
        return errmsg;
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
