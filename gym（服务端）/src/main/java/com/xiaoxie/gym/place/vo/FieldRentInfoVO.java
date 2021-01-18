package com.xiaoxie.gym.place.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @create 2020-05-30  23:13
 */

@ApiModel("设置特殊使用的VO")
public class FieldRentInfoVO {

    @ApiModelProperty(value = "场地名称")
    private String fieldName;

    @ApiModelProperty(value = "场地地点")
    private String fieldLocal;

    @ApiModelProperty(value = "租用开始日期")
    private String rentBegin;

    @ApiModelProperty(value = "租用结束日期")
    private String rentEnd;

    @ApiModelProperty(value = "租用类型（按钮给出，按钮值传入）")
    private String rentType;

    @ApiModelProperty(value = "负责人姓名")
    private String userName;

    @ApiModelProperty(value = "负责人电话")
    private String userTel;

    @ApiModelProperty(value = "租用时间段")
    private String rentTime;

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLocal() {
        return fieldLocal;
    }

    public void setFieldLocal(String fieldLocal) {
        this.fieldLocal = fieldLocal;
    }

    public String getRentBegin() {
        return rentBegin;
    }

    public void setRentBegin(String rentBegin) {
        this.rentBegin = rentBegin;
    }

    public String getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(String rentEnd) {
        this.rentEnd = rentEnd;
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
