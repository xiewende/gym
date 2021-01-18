package com.xiaoxie.gym.competition.mapper;

import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.competition.pojo.JudgeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JudgeMapper {
    int countByExample(JudgeExample example);

    int deleteByExample(JudgeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Judge record);

    int insertSelective(Judge record);

    List<Judge> selectByExample(JudgeExample example);

    Judge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Judge record, @Param("example") JudgeExample example);

    int updateByExample(@Param("record") Judge record, @Param("example") JudgeExample example);

    int updateByPrimaryKeySelective(Judge record);

    int updateByPrimaryKey(Judge record);
}