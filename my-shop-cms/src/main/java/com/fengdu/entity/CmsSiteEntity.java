package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 cms_site
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:38
 */
public class CmsSiteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //预留商城ID
    private String shopid;
    //名称
    private String siteName;
    //域名
    private String siteDomain;
    //ICP
    private String siteIcp;
    //LOGO
    private String siteLogo;
    //WAPLOGO
    private String siteWapLogo;
    //客服QQ
    private String siteQq;
    //邮箱
    private String siteEmail;
    //电话
    private String siteTel;
    //微博
    private String weiboName;
    //微博地址
    private String weiboUrl;
    //微博二维码
    private String weiboQrcode;
    //微信名称
    private String wechatName;
    //微信ID
    private String wechatId;
    //微信二维码
    private String wechatQrcode;
    //关键词
    private String seoKeywords;
    //描述
    private String seoDescription;
    //底部版权
    private String footerContent;
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
     * 设置：名称
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 获取：名称
     */
    public String getSiteName() {
        return siteName;
    }
    /**
     * 设置：域名
     */
    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    /**
     * 获取：域名
     */
    public String getSiteDomain() {
        return siteDomain;
    }
    /**
     * 设置：ICP
     */
    public void setSiteIcp(String siteIcp) {
        this.siteIcp = siteIcp;
    }

    /**
     * 获取：ICP
     */
    public String getSiteIcp() {
        return siteIcp;
    }
    /**
     * 设置：LOGO
     */
    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo;
    }

    /**
     * 获取：LOGO
     */
    public String getSiteLogo() {
        return siteLogo;
    }
    /**
     * 设置：WAPLOGO
     */
    public void setSiteWapLogo(String siteWapLogo) {
        this.siteWapLogo = siteWapLogo;
    }

    /**
     * 获取：WAPLOGO
     */
    public String getSiteWapLogo() {
        return siteWapLogo;
    }
    /**
     * 设置：客服QQ
     */
    public void setSiteQq(String siteQq) {
        this.siteQq = siteQq;
    }

    /**
     * 获取：客服QQ
     */
    public String getSiteQq() {
        return siteQq;
    }
    /**
     * 设置：邮箱
     */
    public void setSiteEmail(String siteEmail) {
        this.siteEmail = siteEmail;
    }

    /**
     * 获取：邮箱
     */
    public String getSiteEmail() {
        return siteEmail;
    }
    /**
     * 设置：电话
     */
    public void setSiteTel(String siteTel) {
        this.siteTel = siteTel;
    }

    /**
     * 获取：电话
     */
    public String getSiteTel() {
        return siteTel;
    }
    /**
     * 设置：微博
     */
    public void setWeiboName(String weiboName) {
        this.weiboName = weiboName;
    }

    /**
     * 获取：微博
     */
    public String getWeiboName() {
        return weiboName;
    }
    /**
     * 设置：微博地址
     */
    public void setWeiboUrl(String weiboUrl) {
        this.weiboUrl = weiboUrl;
    }

    /**
     * 获取：微博地址
     */
    public String getWeiboUrl() {
        return weiboUrl;
    }
    /**
     * 设置：微博二维码
     */
    public void setWeiboQrcode(String weiboQrcode) {
        this.weiboQrcode = weiboQrcode;
    }

    /**
     * 获取：微博二维码
     */
    public String getWeiboQrcode() {
        return weiboQrcode;
    }
    /**
     * 设置：微信名称
     */
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    /**
     * 获取：微信名称
     */
    public String getWechatName() {
        return wechatName;
    }
    /**
     * 设置：微信ID
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    /**
     * 获取：微信ID
     */
    public String getWechatId() {
        return wechatId;
    }
    /**
     * 设置：微信二维码
     */
    public void setWechatQrcode(String wechatQrcode) {
        this.wechatQrcode = wechatQrcode;
    }

    /**
     * 获取：微信二维码
     */
    public String getWechatQrcode() {
        return wechatQrcode;
    }
    /**
     * 设置：关键词
     */
    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    /**
     * 获取：关键词
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }
    /**
     * 设置：描述
     */
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    /**
     * 获取：描述
     */
    public String getSeoDescription() {
        return seoDescription;
    }
    /**
     * 设置：底部版权
     */
    public void setFooterContent(String footerContent) {
        this.footerContent = footerContent;
    }

    /**
     * 获取：底部版权
     */
    public String getFooterContent() {
        return footerContent;
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
