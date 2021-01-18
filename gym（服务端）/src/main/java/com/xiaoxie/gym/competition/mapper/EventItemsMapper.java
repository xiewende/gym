package com.xiaoxie.gym.competition.mapper;


import java.util.List;

import com.xiaoxie.gym.competition.pojo.EventItems;
import com.xiaoxie.gym.competition.pojo.EventItemsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventItemsMapper {
    int countByExample(EventItemsExample example);

    int deleteByExample(EventItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EventItems record);

    int insertSelective(EventItems record);

    List<EventItems> selectByExample(EventItemsExample example);

    EventItems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EventItems record, @Param("example") EventItemsExample example);

    int updateByExample(@Param("record") EventItems record, @Param("example") EventItemsExample example);

    int updateByPrimaryKeySelective(EventItems record);

    int updateByPrimaryKey(EventItems record);
}