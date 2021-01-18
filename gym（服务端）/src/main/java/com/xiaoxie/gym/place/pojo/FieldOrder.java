package com.xiaoxie.gym.place.pojo;

import java.util.Date;

public class FieldOrder {
    private Integer id;

    private Integer fieldId;

    private Integer userId;

    private Date orderData;

    private String orderTime;

    private Double orderCharge;

    private Integer orderStatus;

    private Integer orderDelelte;

    private Date orderBegin;

    private Date orderEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderData() {
        return orderData;
    }

    public void setOrderData(Date orderData) {
        this.orderData = orderData;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public Double getOrderCharge() {
        return orderCharge;
    }

    public void setOrderCharge(Double orderCharge) {
        this.orderCharge = orderCharge;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderDelelte() {
        return orderDelelte;
    }

    public void setOrderDelelte(Integer orderDelelte) {
        this.orderDelelte = orderDelelte;
    }

    public Date getOrderBegin() {
        return orderBegin;
    }

    public void setOrderBegin(Date orderBegin) {
        this.orderBegin = orderBegin;
    }

    public Date getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(Date orderEnd) {
        this.orderEnd = orderEnd;
    }
}