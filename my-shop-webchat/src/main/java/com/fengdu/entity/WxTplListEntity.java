package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 wx_tpl_list
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:37
 */
public class WxTplListEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private String id;
    //模板ID
    private String templateId;
    //模板标题
    private String title;
    //主营行业
    private String primaryIndustry;
    //副营行业
    private String deputyIndustry;
    //模板内容
    private String content;
    //模板示例
    private String example;
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
     * 设置：模板标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：模板标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：主营行业
     */
    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    /**
     * 获取：主营行业
     */
    public String getPrimaryIndustry() {
        return primaryIndustry;
    }
    /**
     * 设置：副营行业
     */
    public void setDeputyIndustry(String deputyIndustry) {
        this.deputyIndustry = deputyIndustry;
    }

    /**
     * 获取：副营行业
     */
    public String getDeputyIndustry() {
        return deputyIndustry;
    }
    /**
     * 设置：模板内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：模板内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：模板示例
     */
    public void setExample(String example) {
        this.example = example;
    }

    /**
     * 获取：模板示例
     */
    public String getExample() {
        return example;
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
