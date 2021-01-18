package com.xiaoxie.gym.place.service;

import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.vo.FieldRentInfoVO;
import com.xiaoxie.gym.place.vo.FieldRentInfooutVO;

import java.util.List;

/**
 * @create 2020-05-29  23:50
 */
public interface FieldRentInfoService{

    //设置场地特使使用
    public Integer setPlaceEspecialUser(FieldRentInfoVO fieldRentInfoVO);

    //查询场地使用情况  条件输入
    public List<FieldRentInfo> getAllFieldRentInfo(String fileName,String type);

    //删除
    public Integer deleteFieldRentInfo(Integer integer);
}
