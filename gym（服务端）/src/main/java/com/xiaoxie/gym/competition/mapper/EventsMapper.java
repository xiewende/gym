package com.xiaoxie.gym.competition.mapper;

import com.xiaoxie.gym.competition.pojo.Events;
import com.xiaoxie.gym.competition.pojo.EventsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EventsMapper {
    int countByExample(EventsExample example);

    int deleteByExample(EventsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Events record);

    int insertSelective(Events record);

    List<Events> selectByExample(EventsExample example);

    Events selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Events record, @Param("example") EventsExample example);

    int updateByExample(@Param("record") Events record, @Param("example") EventsExample example);

    int updateByPrimaryKeySelective(Events record);

    int updateByPrimaryKey(Events record);
}