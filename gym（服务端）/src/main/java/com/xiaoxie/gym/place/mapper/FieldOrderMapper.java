package com.xiaoxie.gym.place.mapper;

import com.xiaoxie.gym.place.pojo.FieldOrder;
import com.xiaoxie.gym.place.pojo.FieldOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FieldOrderMapper {
    int countByExample(FieldOrderExample example);

    int deleteByExample(FieldOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldOrder record);

    int insertSelective(FieldOrder record);

    List<FieldOrder> selectByExample(FieldOrderExample example);

    FieldOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldOrder record, @Param("example") FieldOrderExample example);

    int updateByExample(@Param("record") FieldOrder record, @Param("example") FieldOrderExample example);

    int updateByPrimaryKeySelective(FieldOrder record);

    int updateByPrimaryKey(FieldOrder record);
}