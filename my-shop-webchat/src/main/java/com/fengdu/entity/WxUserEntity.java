package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_user
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
public class WxUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //openid
    private String openid;
    //unionid
    private String unionid;
    //微信昵称
    private String nickname;
    //是否关注
    private Integer subscribe;
    //关注时间
    private Integer subscribeat;
    //性别
    private Integer sex;
    //国家
    private String country;
    //省份
    private String province;
    //城市
    private String city;
    //头像
    private String headimgurl;
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
     * 设置：unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取：unionid
     */
    public String getUnionid() {
        return unionid;
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
     * 设置：是否关注
     */
    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * 获取：是否关注
     */
    public Integer getSubscribe() {
        return subscribe;
    }
    /**
     * 设置：关注时间
     */
    public void setSubscribeat(Integer subscribeat) {
        this.subscribeat = subscribeat;
    }

    /**
     * 获取：关注时间
     */
    public Integer getSubscribeat() {
        return subscribeat;
    }
    /**
     * 设置：性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别
     */
    public Integer getSex() {
        return sex;
    }
    /**
     * 设置：国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取：国家
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置：省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取：省份
     */
    public String getProvince() {
        return province;
    }
    /**
     * 设置：城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取：城市
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置：头像
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取：头像
     */
    public String getHeadimgurl() {
        return headimgurl;
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
