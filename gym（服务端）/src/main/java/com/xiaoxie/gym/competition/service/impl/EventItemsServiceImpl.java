package com.xiaoxie.gym.competition.service.impl;

import com.xiaoxie.gym.competition.mapper.EventItemsMapper;
import com.xiaoxie.gym.competition.pojo.EventItems;
import com.xiaoxie.gym.competition.pojo.EventItemsExample;
import com.xiaoxie.gym.competition.service.EventItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @create 2020-06-01  17:11
 */
@Service
public class EventItemsServiceImpl implements EventItemsService {

    @Autowired
    private EventItemsMapper eventItemsMapper;

    @Override
    public Integer addEventItems(String name) {

        //判断是否存在
        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria criteria = eventItemsExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<EventItems> eventItems1 = eventItemsMapper.selectByExample(eventItemsExample);
        if(eventItems1.size()>0){ //存在
            return 0;
        }

        //不存在，添加
        //构造对象
        EventItems eventItems = new EventItems();
        eventItems.setName(name);
        eventItems.setCreateTime(new Date());
        eventItems.setUpdateTime(new Date());
        eventItems.setDeleted(0);

        int insert = eventItemsMapper.insert(eventItems);

        return insert;
    }

    @Override
    public Integer deleteEventItems(Integer id) {

        EventItems eventItems = eventItemsMapper.selectByPrimaryKey(id);
        eventItems.setDeleted(1);

        return eventItemsMapper.updateByPrimaryKey(eventItems);
    }

    @Override
    public Integer updateEventItems(String name, Integer id) {

        //判断是否存在
        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria criteria = eventItemsExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<EventItems> eventItems1 = eventItemsMapper.selectByExample(eventItemsExample);
        if(eventItems1.size()>0){ //存在
            return 0;
        }

        //修改
        EventItems eventItems = eventItemsMapper.selectByPrimaryKey(id);
        eventItems.setUpdateTime(new Date());
        eventItems.setName(name);

        //执行修改
        int i = eventItemsMapper.updateByPrimaryKey(eventItems);

        return i;
    }

    @Override
    public List<EventItems> seleEventItemsAll() {

        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria criteria = eventItemsExample.createCriteria();
        criteria.andDeletedEqualTo(0);
        List<EventItems> eventItems = eventItemsMapper.selectByExample(eventItemsExample);

        return eventItems;
    }

    @Override

    //根据id查
    public EventItems selectEventItemsById(Integer id) {
        return eventItemsMapper.selectByPrimaryKey(id);
    }
}
