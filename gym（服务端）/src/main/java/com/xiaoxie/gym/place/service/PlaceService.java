package com.xiaoxie.gym.place.service;

import com.xiaoxie.gym.place.pojo.Place;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @create 2020-05-28  21:44
 */

public interface PlaceService {

    //添加场地
    public Integer insertPlace(Place place);

    //查询场地 默认查询空闲状态的场地，若有输入（场地名称）条件，则条件查询，若没有，则查找全部
    public List<Place> selectPlaceByFileName(String filedName);

    //根据id删除场地
    public Integer deletePlace(Integer id);

    //修改课程
    public Integer updatePlace(Place place);

    //根据id查找某场地
    public Place selectPlaceById(Integer id);

}
