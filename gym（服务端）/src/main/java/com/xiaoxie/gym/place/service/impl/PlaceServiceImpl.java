package com.xiaoxie.gym.place.service.impl;

import com.xiaoxie.gym.place.mapper.PlaceMapper;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.pojo.PlaceExample;
import com.xiaoxie.gym.place.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2020-05-28  21:47
 */

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceMapper placeMapper;


    //添加场地
    @Override
    public Integer insertPlace(Place place) {

        //1、查重，若该场地的名称和地点存在，则视为该场地已经存在
        PlaceExample placeExample = new PlaceExample();
        PlaceExample.Criteria placeExampleCriteria = placeExample.createCriteria();
        placeExampleCriteria.andFieldNameEqualTo(place.getFieldName());
        placeExampleCriteria.andFieldLocaleEqualTo(place.getFieldLocale());
        List<Place> placeList = placeMapper.selectByExample(placeExample);
        //已经存在
        if(placeList.size()>0){
            return 0;
        }
        //不存在，则添加
        return placeMapper.insert(place);
    }

    @Override
    //查询场地 默认查询空闲状态的场地，若有输入（场地名称）条件，则模糊条件查询，若没有，则查找全部
    public List<Place> selectPlaceByFileName(String filedName) {
        //设置查询条件
        PlaceExample placeExample = new PlaceExample();
        PlaceExample.Criteria placeExampleCriteria = placeExample.createCriteria();
        //设置默认查询
        placeExampleCriteria.andDeleteTagEqualTo(0); //没有删除
        placeExampleCriteria.andFieldStatusEqualTo(0); //空闲
        //若传参了，则设置查询条件
        if(filedName != null){
            placeExampleCriteria.andFieldNameLike("%"+filedName+"%");
            //placeExampleCriteria.andFieldNameEqualTo(filedName);
        }
        //执行查询
        List<Place> placeList = placeMapper.selectByExample(placeExample);
        return placeList;
    }

    @Override
    //根据id删除课程
    public Integer deletePlace(Integer id) {

        Place place = placeMapper.selectByPrimaryKey(id);
        place.setDeleteTag(1);

        return placeMapper.updateByPrimaryKey(place);

    }

    @Override
    //修改场地信息
    public Integer updatePlace(Place place) {

        Place selectPlace = placeMapper.selectByPrimaryKey(place.getId());

        if(selectPlace.getFieldName().equals(place.getFieldName()) && selectPlace.getFieldLocale().equals(place.getFieldLocale())){
            return placeMapper.updateByPrimaryKey(place);
        }else {
            //查看是否重复 若场地名称和场地地点相同，则相同
            PlaceExample placeExample = new PlaceExample();
            PlaceExample.Criteria criteria = placeExample.createCriteria();
            criteria.andFieldNameEqualTo(place.getFieldName());
            criteria.andFieldLocaleEqualTo(place.getFieldLocale());
            List<Place> places = placeMapper.selectByExample(placeExample);
            if(places.size()>0){  //有重复
                return 0;
            }

            //不存在，则修改
            return placeMapper.updateByPrimaryKey(place);
        }
    }

    @Override
    //根据id查找场地
    public Place selectPlaceById(Integer id) {

        //执行查询
        Place place = placeMapper.selectByPrimaryKey(id);

        return place;
    }
}
