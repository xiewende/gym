package com.xiaoxie.gym.competition.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @create 2020-06-01  21:06
 */

@ApiModel("添加赛事表单")
public class competitionVO {




    @ApiModelProperty(value = "赛事项目")
    private String eventItemName;  //赛事项目

    @ApiModelProperty(value = "赛事名称")
    private String name;   //赛事名称

    @ApiModelProperty(value = "赛事开始时间")
    private String startTime;  //赛事开始时间

    @ApiModelProperty(value = "赛事结束时间")
    private String endTime; //赛事结束时间

    @ApiModelProperty(value = "场地名称")
    private String placeName;  //场地名称

    @ApiModelProperty(value = "场地地点")
    private String placeLocal; //场地地点

    @ApiModelProperty(value = "场地器材")
    private String equipment;  //场地器材

    @ApiModelProperty(value = "裁判名字")
    private String judgeName;  //裁判名字

    @ApiModelProperty(value = "队伍名字")
    private String teams;   //队伍名字

    @ApiModelProperty(value = "备注")
    private String note;  //备注



    public String getEventItemName() {
        return eventItemName;
    }

    public void setEventItemName(String eventItemName) {
        this.eventItemName = eventItemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocal() {
        return placeLocal;
    }

    public void setPlaceLocal(String placeLocal) {
        this.placeLocal = placeLocal;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
