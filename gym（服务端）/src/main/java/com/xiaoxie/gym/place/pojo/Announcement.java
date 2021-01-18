package com.xiaoxie.gym.place.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("场地公共")
public class Announcement {

    @ApiModelProperty(value = "id（前端不需要输入）")
    private Integer id;

    @ApiModelProperty(value = "公共告标题")
    private String announcementTitle;

    @ApiModelProperty(value = "公告作者")
    private String announcementAuthor;

    @ApiModelProperty(value = "公共日期（不需要输入）")
    private Date announcementTime;

    @ApiModelProperty(value = "公共内容")
    private String announcementConten;

    @ApiModelProperty(value = "删除（不需要输入）")
    private Integer announcementDelelte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle == null ? null : announcementTitle.trim();
    }

    public String getAnnouncementAuthor() {
        return announcementAuthor;
    }

    public void setAnnouncementAuthor(String announcementAuthor) {
        this.announcementAuthor = announcementAuthor == null ? null : announcementAuthor.trim();
    }

    public Date getAnnouncementTime() {
        return announcementTime;
    }

    public void setAnnouncementTime(Date announcementTime) {
        this.announcementTime = announcementTime;
    }

    public String getAnnouncementConten() {
        return announcementConten;
    }

    public void setAnnouncementConten(String announcementConten) {
        this.announcementConten = announcementConten == null ? null : announcementConten.trim();
    }

    public Integer getAnnouncementDelelte() {
        return announcementDelelte;
    }

    public void setAnnouncementDelelte(Integer announcementDelelte) {
        this.announcementDelelte = announcementDelelte;
    }
}