package com.xiaoxie.gym.competition.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @create 2020-06-01  22:17
 */
public class competitonOutVo {

    private Integer id;

    private String eventItemName;  //赛事项目

    private String name;   //赛事名称

    private Date startTime;  //赛事开始时间

    private Date endTime; //赛事结束时间

    private String placeName;  //场地名称

    private String placeLocal; //场地地点

    private String equipment;  //场地器材

    private String judgeName;  //裁判名字

    private String teams;   //队伍名字

    private String note;  //备注

    //
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
