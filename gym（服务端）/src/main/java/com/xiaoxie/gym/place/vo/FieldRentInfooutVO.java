package com.xiaoxie.gym.place.vo;

import java.util.Date;

/**
 * @create 2020-05-31  21:00
 */
public class FieldRentInfooutVO {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String fieldName;  //场地名称
    private String fieldLocale;  //场地地点
    private String fieldTime;  //场地开放时间
    private Date rentBegin;  //租用开始
    private Date rentEnd;  //租用结束
    private Double rentCharge;  //费用
    private String fieldStatus;  //状态
    private String rentType;  // 租用类型
    private String userName;  //租用用户名
    private String userTel; //租用人电话


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

    public String getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(String fieldTime) {
        this.fieldTime = fieldTime;
    }

    public Date getRentBegin() {
        return rentBegin;
    }

    public void setRentBegin(Date rentBegin) {
        this.rentBegin = rentBegin;
    }

    public Date getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    public Double getRentCharge() {
        return rentCharge;
    }

    public void setRentCharge(Double rentCharge) {
        this.rentCharge = rentCharge;
    }

    public String getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(String fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
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






}
