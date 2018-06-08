package com.fengdu.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 pay_way
 *
 * @author william_w
 * @email 2366207000@qq.com
 * @date 2018-05-24 18:01:14
 */
public class PayWayEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private String id;
    //version
    private Long version;
    //创建时间
    private Date createTime;
    //修改时间
    private Date editTime;
    //支付方式编号
    private String payWayCode;
    //支付方式名称
    private String payWayName;
    //支付类型编号
    private String payTypeCode;
    //支付类型名称
    private String payTypeName;
    //支付产品编号
    private String payProductCode;
    //状态(100:正常状态,101非正常状态)
    private String status;
    //排序(倒序排序,默认值1000)
    private Integer sorts;
    //商户支付费率
    private Double payRate;

    /**
     * 设置：id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：id
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取：version
     */
    public Long getVersion() {
        return version;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：修改时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getEditTime() {
        return editTime;
    }
    /**
     * 设置：支付方式编号
     */
    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode;
    }

    /**
     * 获取：支付方式编号
     */
    public String getPayWayCode() {
        return payWayCode;
    }
    /**
     * 设置：支付方式名称
     */
    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    /**
     * 获取：支付方式名称
     */
    public String getPayWayName() {
        return payWayName;
    }
    /**
     * 设置：支付类型编号
     */
    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }

    /**
     * 获取：支付类型编号
     */
    public String getPayTypeCode() {
        return payTypeCode;
    }
    /**
     * 设置：支付类型名称
     */
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    /**
     * 获取：支付类型名称
     */
    public String getPayTypeName() {
        return payTypeName;
    }
    /**
     * 设置：支付产品编号
     */
    public void setPayProductCode(String payProductCode) {
        this.payProductCode = payProductCode;
    }

    /**
     * 获取：支付产品编号
     */
    public String getPayProductCode() {
        return payProductCode;
    }
    /**
     * 设置：状态(100:正常状态,101非正常状态)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：状态(100:正常状态,101非正常状态)
     */
    public String getStatus() {
        return status;
    }
    /**
     * 设置：排序(倒序排序,默认值1000)
     */
    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    /**
     * 获取：排序(倒序排序,默认值1000)
     */
    public Integer getSorts() {
        return sorts;
    }
    /**
     * 设置：商户支付费率
     */
    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }

    /**
     * 获取：商户支付费率
     */
    public Double getPayRate() {
        return payRate;
    }
}
