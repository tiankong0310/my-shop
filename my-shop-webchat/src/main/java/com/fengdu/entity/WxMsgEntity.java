package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_msg
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxMsgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //openid
    private String openid;
    //微信昵称
    private String nickname;
    //信息类型
    private String type;
    //信息内容
    private String content;
    //回复ID
    private String replyid;
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
     * 设置：openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取：openid
     */
    public String getOpenid() {
        return openid;
    }
    /**
     * 设置：微信昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取：微信昵称
     */
    public String getNickname() {
        return nickname;
    }
    /**
     * 设置：信息类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：信息类型
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：信息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：信息内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：回复ID
     */
    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    /**
     * 获取：回复ID
     */
    public String getReplyid() {
        return replyid;
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
