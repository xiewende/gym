package com.xiaoxie.gym.place.service.impl;

import com.xiaoxie.gym.place.mapper.AnnouncementMapper;
import com.xiaoxie.gym.place.pojo.Announcement;
import com.xiaoxie.gym.place.pojo.AnnouncementExample;
import com.xiaoxie.gym.place.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2020-05-30  0:21
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    //增加公告
    public Integer insertAnnouncement(Announcement announcement) {
        return announcementMapper.insert(announcement);
    }

    @Override
    //查询全部公告
    public List<Announcement> listAllAnnouncement() {
        AnnouncementExample announcementExample = new AnnouncementExample();
        AnnouncementExample.Criteria criteria = announcementExample.createCriteria();
        //没有删除
        criteria.andAnnouncementDelelteEqualTo(0);
        announcementExample.setOrderByClause("id desc");
        List<Announcement> announcements = announcementMapper.selectByExample(announcementExample);
        return announcements;
    }

    //删除公共
    @Override
    public Integer deleteAnnouncement(Integer id) {
        Announcement announcement = announcementMapper.selectByPrimaryKey(id);
        announcement.setAnnouncementDelelte(1);
        return announcementMapper.updateByPrimaryKey(announcement);
    }

    @Override
    //查询最新公告（用户端）
    public Announcement selectByRencent() {
        //按时间排序，拿最近的一条数据
        AnnouncementExample announcementExample = new AnnouncementExample();
        AnnouncementExample.Criteria criteria = announcementExample.createCriteria();
        //没有删除
        criteria.andAnnouncementDelelteEqualTo(0);
        //announcementExample.setOrderByClause("announcement_time desc");
        announcementExample.setOrderByClause("id desc");
        List<Announcement> announcements = announcementMapper.selectByExample(announcementExample);
        return announcements.get(0);
    }
}
