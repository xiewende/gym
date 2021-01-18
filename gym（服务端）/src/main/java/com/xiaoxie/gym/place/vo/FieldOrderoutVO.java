package com.xiaoxie.gym.place.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @create 2020-05-31  22:28
 */
public class FieldOrderoutVO {

    private Integer id;
    private String fieldName;
    private String fieldLocale;
    private String userName;
    private String userTel;
    private String orderTime;
    private Double rentCharge;
    private Date orderBegin;
    private Date orderEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLocale() {
        return fieldLocale;
    }

    public void setFieldLocale(String fieldLocale) {
        this.fieldLocale = fieldLocale;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getRentCharge() {
        return rentCharge;
    }

    public void setRentCharge(Double rentCharge) {
        this.rentCharge = rentCharge;
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
