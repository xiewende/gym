package com.xiaoxie.gym.place.service.impl;

import com.xiaoxie.gym.place.mapper.FieldRentInfoMapper;
import com.xiaoxie.gym.place.mapper.PlaceMapper;
import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.pojo.FieldRentInfoExample;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.pojo.PlaceExample;
import com.xiaoxie.gym.place.service.FieldRentInfoService;
import com.xiaoxie.gym.place.vo.FieldRentInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @create 2020-05-29  23:50
 */
@Service
public class FieldRentInfoServiceImpl implements FieldRentInfoService {

    @Autowired
    private FieldRentInfoMapper fieldRentInfoMapper;
    @Autowired
    private PlaceMapper placeMapper;

    @Override
    //设置场地的特殊使用
    public Integer setPlaceEspecialUser (FieldRentInfoVO fieldRentInfoVO) {
        FieldRentInfo fieldRentInfo = new FieldRentInfo();
        //根据场地名称，场地地点查找场地id
        PlaceExample placeExample = new PlaceExample();
        PlaceExample.Criteria criteria = placeExample.createCriteria();
        criteria.andFieldNameEqualTo(fieldRentInfoVO.getFieldName());
        criteria.andFieldLocaleEqualTo(fieldRentInfoVO.getFieldLocal());
        List<Place> places = placeMapper.selectByExample(placeExample);
        Place place = places.get(0);
        //设置
        fieldRentInfo.setFieldId(place.getId());
        fieldRentInfo.setRentCharge(60.00);
        //根据前端的按钮把值传入，根据这个值设置对应的租用类型状态
        if(fieldRentInfoVO.getRentType().equals("上课用地")){
            fieldRentInfo.setRentType(1);
        }
        if(fieldRentInfoVO.getRentType().equals("校队用地")){
            fieldRentInfo.setRentType(2);
        }
        if(fieldRentInfoVO.getRentType().equals("普通申请")){
            fieldRentInfo.setRentType(0);
        }
        //设置租用状态
        fieldRentInfo.setRentStatus(3);
        //申请日期
        fieldRentInfo.setRentData(new Date());
        //没有删除
        fieldRentInfo.setDeleteTag(0);
        //使用时间段
        fieldRentInfo.setRentTime(fieldRentInfoVO.getRentTime());
        //租用开始时间  租用结束时间
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            Date rentBegin = ft.parse(fieldRentInfoVO.getRentBegin());
            fieldRentInfo.setRentBegin(rentBegin);
            Date rentEnd = ft.parse(fieldRentInfoVO.getRentEnd());
            fieldRentInfo.setRentEnd(rentEnd);
        }catch (Exception e){
            e.printStackTrace();
        }
        //执行查询
        int insert = fieldRentInfoMapper.insert(fieldRentInfo);
        return insert;
    }

    @Override
    //查询场地使用情况  条件输入
    public List<FieldRentInfo> getAllFieldRentInfo(String fileName, String type) {
        FieldRentInfoExample fieldRentInfoExample = new FieldRentInfoExample();
        FieldRentInfoExample.Criteria criteria = fieldRentInfoExample.createCriteria();
        //查询场地名称对应的场地id
        List<Integer> palceIds = new ArrayList<>();
        if(fileName!=null){
            PlaceExample placeExample = new PlaceExample();
            PlaceExample.Criteria exampleCriteria = placeExample.createCriteria();
            //模糊
            //exampleCriteria.andFieldNameEqualTo(fileName);
            exampleCriteria.andFieldNameLike("%"+fileName+"%");
            List<Place> places = placeMapper.selectByExample(placeExample);
            for(Place place : places){
                palceIds.add(place.getId());
            }
            if(palceIds.size()>0){
                criteria.andFieldIdIn(palceIds);
            }else{
                return null;
            }
        }
        if(type != null){
            if(type.equals("普通申请")){
                criteria.andRentTypeEqualTo(0);
            }else if(type.equals("上课用地")){
                criteria.andRentTypeEqualTo(1);
            }else if(type.equals("校队用地")){
                criteria.andRentTypeEqualTo(2);
            }else {
                return null;
            }

        }
        criteria.andDeleteTagEqualTo(0);
        //执行查询
        List<FieldRentInfo> fieldRentInfos = fieldRentInfoMapper.selectByExample(fieldRentInfoExample);
        return fieldRentInfos;
    }

    @Override
    public Integer deleteFieldRentInfo(Integer integer) {
        FieldRentInfo fieldRentInfo = fieldRentInfoMapper.selectByPrimaryKey(integer);
        fieldRentInfo.setDeleteTag(1);
        return fieldRentInfoMapper.updateByPrimaryKey(fieldRentInfo);
    }
}
