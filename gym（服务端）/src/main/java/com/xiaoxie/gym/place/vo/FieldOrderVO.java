package com.xiaoxie.gym.place.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @create 2020-05-31  21:58
 */

@ApiModel("场地预约Vo")
public class FieldOrderVO {

    @ApiModelProperty(value = "场地id")
    private Integer fieldId;

    @ApiModelProperty(value = "预约人id")
    private Integer userId;

    @ApiModelProperty(value = "场地开放时间")
    private String orderTime;

    @ApiModelProperty(value = "租用开始日期")
    private String orderBegin;

    @ApiModelProperty(value = "租用结束日期")
    private String orderEnd;

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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderBegin() {
        return orderBegin;
    }

    public void setOrderBegin(String orderBegin) {
        this.orderBegin = orderBegin;
    }

    public String getOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(String orderEnd) {
        this.orderEnd = orderEnd;
    }
}
