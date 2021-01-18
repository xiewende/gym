package com.xiaoxie.gym.place.service;

import com.xiaoxie.gym.place.vo.FieldOrderPersonoutVO;
import com.xiaoxie.gym.place.vo.FieldOrderVO;
import com.xiaoxie.gym.place.vo.FieldOrderoutVO;

import java.util.List;

/**
 * @create 2020-05-31  22:02
 */
public interface FieldOrderService {

    //普通用户预约场地
    public Integer fileOrder(FieldOrderVO fieldOrderVO);

    //查询预约表
    public List<FieldOrderoutVO> listAllOrderField(String fieldName);

    //同意预约
    public Integer agreefileOrder(Integer id);

    //不同意预约
    public Integer disagreefileOrder(Integer id);

    //普通用户查询自己的预约情况
    public List<FieldOrderPersonoutVO> selectPersonOeder(Integer userId);

}
