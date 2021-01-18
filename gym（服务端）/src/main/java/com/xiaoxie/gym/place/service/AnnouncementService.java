package com.xiaoxie.gym.place.service;

import com.xiaoxie.gym.place.pojo.Announcement;

import java.util.List;

/**
 * @create 2020-05-30  0:20
 */
public interface AnnouncementService {

    //增加公告
    public Integer insertAnnouncement(Announcement announcement);

    //查询全部公告
    public List<Announcement> listAllAnnouncement();

    //删除公共
    public Integer deleteAnnouncement(Integer id);

    //查询最新公共（用户端）
    public Announcement selectByRencent();


}
