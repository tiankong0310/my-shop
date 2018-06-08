package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 cms_class_link
 *
 * @author william_w
 * @email 939961241@qq.com
 * @date 2018-05-24 15:56:39
 */
public class CmsClassLinkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String classid;
    //
    private String linkid;

    /**
     * 设置：
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }

    /**
     * 获取：
     */
    public String getClassid() {
        return classid;
    }
    /**
     * 设置：
     */
    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    /**
     * 获取：
     */
    public String getLinkid() {
        return linkid;
    }
}
