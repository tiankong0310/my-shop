package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_reply
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxReplyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //回复类型
    private String type;
    //消息类型
    private String msgtype;
    //关键词
    private String keyword;
    //回复内容
    private String content;
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
     * 设置：回复类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：回复类型
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：消息类型
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * 获取：消息类型
     */
    public String getMsgtype() {
        return msgtype;
    }
    /**
     * 设置：关键词
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取：关键词
     */
    public String getKeyword() {
        return keyword;
    }
    /**
     * 设置：回复内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：回复内容
     */
    public String getContent() {
        return content;
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
