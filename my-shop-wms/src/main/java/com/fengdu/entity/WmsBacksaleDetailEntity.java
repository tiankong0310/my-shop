package com.fengdu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 实体
 * 表名 wms_backsale_detail
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-06-04 15:09:33
 */
public class WmsBacksaleDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String id;
    //
    private String backsaleId;
    //
    private String productId;
    //
    private Integer quantity;
    //
    private BigDecimal price;
    //
    private Date createdate;
    //
    private String createby;
    //
    private Date updatedate;
    //
    private String updateby;
    //
    private String enable;
    //
    private Integer sortNo;

    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setBacksaleId(String backsaleId) {
        this.backsaleId = backsaleId;
    }

    /**
     * 获取：
     */
    public String getBacksaleId() {
        return backsaleId;
    }
    /**
     * 设置：
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取：
     */
    public String getProductId() {
        return productId;
    }
    /**
     * 设置：
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取：
     */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * 设置：
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * 设置：
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取：
     */
    public Date getCreatedate() {
        return createdate;
    }
    /**
     * 设置：
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * 获取：
     */
    public String getCreateby() {
        return createby;
    }
    /**
     * 设置：
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：
     */
    public Date getUpdatedate() {
        return updatedate;
    }
    /**
     * 设置：
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    /**
     * 获取：
     */
    public String getUpdateby() {
        return updateby;
    }
    /**
     * 设置：
     */
    public void setEnable(String enable) {
        this.enable = enable;
    }

    /**
     * 获取：
     */
    public String getEnable() {
        return enable;
    }
    /**
     * 设置：
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取：
     */
    public Integer getSortNo() {
        return sortNo;
    }
}
