package com.xiaoxie.gym.competition.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @create 2020-06-01  18:07
 */
@ApiModel("JudgeVO")
public class JudgeVO {

    @ApiModelProperty(value = "裁判名字")
    private String name;  //裁判名字

    @ApiModelProperty(value = "裁判照片")
    private String photoUrl;  //裁判照片

    @ApiModelProperty(value = "裁判专才")
    private String specialities; //裁判专才

    @ApiModelProperty(value = "裁判简介")
    private String profile;  //裁判简介

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
