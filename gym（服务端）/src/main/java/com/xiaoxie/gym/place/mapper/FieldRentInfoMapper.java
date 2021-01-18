package com.xiaoxie.gym.place.mapper;

import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.pojo.FieldRentInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FieldRentInfoMapper {
    int countByExample(FieldRentInfoExample example);

    int deleteByExample(FieldRentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldRentInfo record);

    int insertSelective(FieldRentInfo record);

    List<FieldRentInfo> selectByExample(FieldRentInfoExample example);

    FieldRentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldRentInfo record, @Param("example") FieldRentInfoExample example);

    int updateByExample(@Param("record") FieldRentInfo record, @Param("example") FieldRentInfoExample example);

    int updateByPrimaryKeySelective(FieldRentInfo record);

    int updateByPrimaryKey(FieldRentInfo record);
}