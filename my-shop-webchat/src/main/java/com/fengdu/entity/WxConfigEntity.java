package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_config
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //公众号名称
    private String appname;
    //原始ID
    private String ghid;
    //Appid
    private String appid;
    //Appsecret
    private String appsecret;
    //EncodingAESKey
    private String encodingaeskey;
    //Token
    private String token;
    //access_token
    private String accessToken;
    //access_token_expires
    private Integer accessTokenExpires;
    //access_token_lastat
    private String accessTokenLastat;
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
     * 设置：公众号名称
     */
    public void setAppname(String appname) {
        this.appname = appname;
    }

    /**
     * 获取：公众号名称
     */
    public String getAppname() {
        return appname;
    }
    /**
     * 设置：原始ID
     */
    public void setGhid(String ghid) {
        this.ghid = ghid;
    }

    /**
     * 获取：原始ID
     */
    public String getGhid() {
        return ghid;
    }
    /**
     * 设置：Appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * 获取：Appid
     */
    public String getAppid() {
        return appid;
    }
    /**
     * 设置：Appsecret
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    /**
     * 获取：Appsecret
     */
    public String getAppsecret() {
        return appsecret;
    }
    /**
     * 设置：EncodingAESKey
     */
    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey;
    }

    /**
     * 获取：EncodingAESKey
     */
    public String getEncodingaeskey() {
        return encodingaeskey;
    }
    /**
     * 设置：Token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取：Token
     */
    public String getToken() {
        return token;
    }
    /**
     * 设置：access_token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取：access_token
     */
    public String getAccessToken() {
        return accessToken;
    }
    /**
     * 设置：access_token_expires
     */
    public void setAccessTokenExpires(Integer accessTokenExpires) {
        this.accessTokenExpires = accessTokenExpires;
    }

    /**
     * 获取：access_token_expires
     */
    public Integer getAccessTokenExpires() {
        return accessTokenExpires;
    }
    /**
     * 设置：access_token_lastat
     */
    public void setAccessTokenLastat(String accessTokenLastat) {
        this.accessTokenLastat = accessTokenLastat;
    }

    /**
     * 获取：access_token_lastat
     */
    public String getAccessTokenLastat() {
        return accessTokenLastat;
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
