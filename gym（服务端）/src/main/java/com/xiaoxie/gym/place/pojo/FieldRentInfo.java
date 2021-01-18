package com.xiaoxie.gym.place.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("场地租用信息")
public class FieldRentInfo {

   /*
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
    */

    private String fieldName;  //场地名称
    private String fieldLocale;  //场地地点
    // fieldTime rentTime
    private String fieldTime;  //场地开放时间
    private String fieldStatus;  //状态
    private String rentTypeString;  // 租用类型
    private String userName;  //租用用户名
    private String userTel; //租用人电话



    private Integer id;
    private Integer fieldId;
    private Integer tentuserId;
    private Date rentData;
    private Integer rentStatus;
    private Integer rentType;
    private String rentTime;
    private Date rentBegin;
    private Date rentEnd;
    private Double rentCharge;
    private Integer deleteTag;

    public String getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(String fieldTime) {
        this.fieldTime = fieldTime;
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

    public String getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(String fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public String getRentTypeString() {
        return rentTypeString;
    }

    public void setRentTypeString(String rentTypeString) {
        this.rentTypeString = rentTypeString;
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

    public Integer getTentuserId() {
        return tentuserId;
    }

    public void setTentuserId(Integer tentuserId) {
        this.tentuserId = tentuserId;
    }

    public Date getRentData() {
        return rentData;
    }

    public void setRentData(Date rentData) {
        this.rentData = rentData;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime == null ? null : rentTime.trim();
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

    public Integer getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Integer deleteTag) {
        this.deleteTag = deleteTag;
    }
}