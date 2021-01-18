package com.xiaoxie.gym.competition.pojo;

import java.util.Date;

public class Events {

      /* private Integer id;
        private String eventItemName;  //赛事项目
        private String name;   //赛事名称
        private String startTime;  //赛事开始时间
        private String endTime; //赛事结束时间
        private String placeName;  //场地名称
        private String placeLocal; //场地地点
        private String equipment;  //场地器材
        private String judgeName;  //裁判名字
        private String teams;   //队伍名字
        private String note;  //备注*/

    private String eventItemName; //赛事项目
    private String placeName;  //场地名称
    private String placeLocal; //场地地点
    private String judgeName;  //裁判名字
    private String statusString;//状态

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getEventItemName() {
        return eventItemName;
    }

    public void setEventItemName(String eventItemName) {
        this.eventItemName = eventItemName;
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

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    private Integer id;

    private Integer status;

    private Integer eventItemId;

    private String name;

    private Date startTime;

    private Date endTime;

    private Integer placeId;

    private String equipment;

    private Integer judgeId;

    private String teams;

    private String note;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEventItemId() {
        return eventItemId;
    }

    public void setEventItemId(Integer eventItemId) {
        this.eventItemId = eventItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams == null ? null : teams.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}