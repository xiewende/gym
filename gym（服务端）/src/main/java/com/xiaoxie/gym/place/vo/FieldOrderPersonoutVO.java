package com.xiaoxie.gym.place.vo;

import java.util.Date;

/**
 * @create 2020-05-31  23:09
 */
public class FieldOrderPersonoutVO {

    private String fieldName;
    private String fieldLocale;
    private String orderTime;  //场地开放时间
    private Double rentCharge;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Date orderBegin;
    private Date orderEnd;

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
