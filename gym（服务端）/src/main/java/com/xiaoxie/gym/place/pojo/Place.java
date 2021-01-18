package com.xiaoxie.gym.place.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "场地")
public class Place {

    @ApiModelProperty(value = "id（前端不需要输入）")
    private Integer id;

    @ApiModelProperty(value = "场地名称")
    private String fieldName;

    @ApiModelProperty(value = "场地地点")
    private String fieldLocale;

    @ApiModelProperty(value = "场地开放时间")
    private String fieldTime;

    @ApiModelProperty(value = "收费")
    private Double fieldCharge;

    @ApiModelProperty(value = "管理员姓名")
    private String fieldManagername;

    @ApiModelProperty(value = "管理员手机号")
    private String fieldManegertel;

    @ApiModelProperty(value = "场地状态（前端不需要输入）")  //空闲 0，租用中 1，已预约 2，特殊状态 3，完成预约 4
    private Integer fieldStatus;

    @ApiModelProperty(value = "逻辑删除（前端不需要输入）")   // 0没有删除  1 已经删除
    private Integer deleteTag;

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
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldLocale() {
        return fieldLocale;
    }

    public void setFieldLocale(String fieldLocale) {
        this.fieldLocale = fieldLocale == null ? null : fieldLocale.trim();
    }

    public String getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(String fieldTime) {
        this.fieldTime = fieldTime == null ? null : fieldTime.trim();
    }

    public Double getFieldCharge() {
        return fieldCharge;
    }

    public void setFieldCharge(Double fieldCharge) {
        this.fieldCharge = fieldCharge;
    }

    public String getFieldManagername() {
        return fieldManagername;
    }

    public void setFieldManagername(String fieldManagername) {
        this.fieldManagername = fieldManagername == null ? null : fieldManagername.trim();
    }

    public String getFieldManegertel() {
        return fieldManegertel;
    }

    public void setFieldManegertel(String fieldManegertel) {
        this.fieldManegertel = fieldManegertel == null ? null : fieldManegertel.trim();
    }

    public Integer getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(Integer fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public Integer getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Integer deleteTag) {
        this.deleteTag = deleteTag;
    }
}