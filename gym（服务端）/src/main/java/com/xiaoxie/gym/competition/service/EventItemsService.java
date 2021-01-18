package com.xiaoxie.gym.competition.service;

import com.xiaoxie.gym.competition.pojo.EventItems;

import java.util.List;

/**
 * @create 2020-06-01  17:11
 */
public interface EventItemsService {

    //添加
    public Integer addEventItems(String name);

    //删除
    public Integer deleteEventItems(Integer id);

    //修改
    public Integer updateEventItems(String name,Integer id);

    //查询
    public List<EventItems> seleEventItemsAll();

    //根据id查询
    public EventItems selectEventItemsById(Integer id);
}
