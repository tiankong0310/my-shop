package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_mass_news
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class WxMassNewsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //缩略图
    private String thumbMediaId;
    //作者
    private String author;
    //标题
    private String title;
    //原地址
    private String contentSourceUrl;
    //图文内容
    private String content;
    //摘要
    private String digest;
    //显示封面
    private Integer showCoverPic;
    //排序字段
    private Integer location;
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
     * 设置：缩略图
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    /**
     * 获取：缩略图
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }
    /**
     * 设置：作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取：作者
     */
    public String getAuthor() {
        return author;
    }
    /**
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：原地址
     */
    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    /**
     * 获取：原地址
     */
    public String getContentSourceUrl() {
        return contentSourceUrl;
    }
    /**
     * 设置：图文内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：图文内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：摘要
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * 获取：摘要
     */
    public String getDigest() {
        return digest;
    }
    /**
     * 设置：显示封面
     */
    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    /**
     * 获取：显示封面
     */
    public Integer getShowCoverPic() {
        return showCoverPic;
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
