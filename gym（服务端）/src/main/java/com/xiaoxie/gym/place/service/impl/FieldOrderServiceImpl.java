package com.xiaoxie.gym.place.service.impl;

import com.xiaoxie.gym.place.mapper.FieldOrderMapper;
import com.xiaoxie.gym.place.mapper.FieldRentInfoMapper;
import com.xiaoxie.gym.place.mapper.PlaceMapper;
import com.xiaoxie.gym.place.pojo.*;
import com.xiaoxie.gym.place.service.FieldOrderService;
import com.xiaoxie.gym.place.util.GetUser;
import com.xiaoxie.gym.place.util.User;
import com.xiaoxie.gym.place.vo.FieldOrderPersonoutVO;
import com.xiaoxie.gym.place.vo.FieldOrderVO;
import com.xiaoxie.gym.place.vo.FieldOrderoutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @create 2020-05-31  22:10
 */
@Service
public class FieldOrderServiceImpl implements FieldOrderService {

    @Autowired
    private FieldOrderMapper fieldOrderMapper;
    @Autowired
    private PlaceMapper placeMapper;
    @Autowired
    private FieldRentInfoMapper fieldRentInfoMapper;


    @Override
    //普通用户预约场地
    public Integer fileOrder(FieldOrderVO fieldOrderVO) {
        //用户id
        fieldOrderVO.setUserId(fieldOrderVO.getUserId());
        //封装对象
        FieldOrder fieldOrder = new FieldOrder();
        fieldOrder.setFieldId(fieldOrderVO.getFieldId());
        fieldOrder.setUserId(fieldOrderVO.getUserId());
        fieldOrder.setOrderCharge(60.00); //TODO
        fieldOrder.setOrderTime(fieldOrderVO.getOrderTime());
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            Date rentBegin = ft.parse(fieldOrderVO.getOrderBegin());
            fieldOrder.setOrderBegin(rentBegin);
            Date rentEnd = ft.parse(fieldOrderVO.getOrderEnd());
            fieldOrder.setOrderEnd(rentEnd);
        }catch (Exception e){
            e.printStackTrace();
        }
        //其他默认属性
        fieldOrder.setOrderData(new Date());
        fieldOrder.setOrderStatus(1);  //审核中的，
        fieldOrder.setOrderDelelte(0);
        //执行插入
        int insert = fieldOrderMapper.insert(fieldOrder);
        return insert;
    }

    @Override
    //查询预约表
    public List<FieldOrderoutVO> listAllOrderField(String fieldName) {

        //返回的结果集
        List<FieldOrderoutVO> fieldOrderoutVOS = new ArrayList<>();

        FieldOrderExample fieldOrderExample = new FieldOrderExample();
        FieldOrderExample.Criteria fieldOrderExampleCriteria = fieldOrderExample.createCriteria();

        //拿取场地id
        List<Integer> fieldIds = new ArrayList<>();
        if(fieldName != null){
            PlaceExample placeExample = new PlaceExample();
            PlaceExample.Criteria placeExampleCriteria = placeExample.createCriteria();
            placeExampleCriteria.andFieldNameEqualTo(fieldName);
            List<Place> places = placeMapper.selectByExample(placeExample);
            for (Place place : places){
                fieldIds.add(place.getId());
            }
            if(fieldIds.size()>0){
                fieldOrderExampleCriteria.andFieldIdIn(fieldIds);
            }else {
                return fieldOrderoutVOS;
            }
        }

        fieldOrderExampleCriteria.andOrderDelelteEqualTo(0);
        fieldOrderExampleCriteria.andOrderStatusEqualTo(1); //审核中的，

        //执行查询
        List<FieldOrder> fieldOrders = fieldOrderMapper.selectByExample(fieldOrderExample);
        //封装数据
        //private Integer id;
        //    private String fieldName;
        //    private String fieldLocale;
        //    private String userName;
        //    private String userTel;
        //    private String orderTime;
        //    private Double rentCharge;
        //    private Date orderBegin;
        //    private Date orderEnd;
        for (FieldOrder fieldOrder : fieldOrders){
            FieldOrderoutVO fieldOrderoutVO = new FieldOrderoutVO();

            fieldOrderoutVO.setId(fieldOrder.getId());

            //场地名称 地点
            fieldOrderoutVO.setFieldName( placeMapper.selectByPrimaryKey(fieldOrder.getFieldId()).getFieldName());
            fieldOrderoutVO.setFieldLocale(placeMapper.selectByPrimaryKey(fieldOrder.getFieldId()).getFieldLocale());

            //根据id拿用户id  //TODO  用户
            if(fieldOrder.getUserId()!=null){
                User user = GetUser.getUser(fieldOrder.getUserId());
                if(user == null){
                    fieldOrderoutVO.setUserName("Seven");
                    fieldOrderoutVO.setUserTel("17876208191");
                }else {
                    fieldOrderoutVO.setUserName(user.getName());
                    fieldOrderoutVO.setUserTel(user.getPhone());
                }
            }else {
                fieldOrderoutVO.setUserName("Seven");
                fieldOrderoutVO.setUserTel("17876208191");
            }

            fieldOrderoutVO.setOrderTime(fieldOrder.getOrderTime());

            fieldOrderoutVO.setRentCharge(fieldOrder.getOrderCharge());

            fieldOrderoutVO.setOrderBegin(fieldOrder.getOrderBegin());
            fieldOrderoutVO.setOrderEnd(fieldOrder.getOrderEnd());

            //添加
            fieldOrderoutVOS.add(fieldOrderoutVO);
        }


        return fieldOrderoutVOS;
    }

    @Override
    //同意预约
    public Integer agreefileOrder(Integer id) {
        FieldOrder fieldOrder = fieldOrderMapper.selectByPrimaryKey(id);
        fieldOrder.setOrderStatus(0); // 同意
        int i = fieldOrderMapper.updateByPrimaryKey(fieldOrder);
        //同时将预约信息存在 场地租用信息表 中Field_rent_info
        FieldRentInfo fieldRentInfo = new FieldRentInfo();
        fieldRentInfo.setTentuserId(fieldOrder.getUserId());
        fieldRentInfo.setFieldId(fieldOrder.getFieldId());
        fieldRentInfo.setTentuserId(fieldOrder.getUserId());
        fieldRentInfo.setRentData(fieldOrder.getOrderData());
        fieldRentInfo.setRentStatus(2);
        fieldRentInfo.setRentType(0);
        fieldRentInfo.setRentTime(fieldOrder.getOrderTime());
        fieldRentInfo.setRentBegin(fieldOrder.getOrderBegin());
        fieldRentInfo.setRentEnd(fieldOrder.getOrderEnd());
        fieldRentInfo.setRentCharge(fieldOrder.getOrderCharge());
        fieldRentInfo.setDeleteTag(0);
        //执行插入
        fieldRentInfoMapper.insert(fieldRentInfo);
        return i;
    }

    @Override
    //不同意预约
    public Integer disagreefileOrder(Integer id) {
        FieldOrder fieldOrder = fieldOrderMapper.selectByPrimaryKey(id);
        fieldOrder.setOrderStatus(2); // 不同意
        int i = fieldOrderMapper.updateByPrimaryKey(fieldOrder);
        return i;
    }

    @Override
    //普通用户查询自己的预约情况
    public List<FieldOrderPersonoutVO> selectPersonOeder(Integer userId) {

        //TODO  用户id
        //userId = 1;

        //返回的结果集
        List<FieldOrderPersonoutVO> fieldOrderPersonoutVOS  = new ArrayList<>();

        //条件查询
        FieldOrderExample fieldOrderExample = new FieldOrderExample();
        FieldOrderExample.Criteria fieldOrderExampleCriteria = fieldOrderExample.createCriteria();
        fieldOrderExampleCriteria.andUserIdEqualTo(userId);
        fieldOrderExampleCriteria.andOrderDelelteEqualTo(0);
        List<FieldOrder> fieldOrders = fieldOrderMapper.selectByExample(fieldOrderExample);

        //封装数据
        if(fieldOrders.size()>0){
           /* private String fieldName;
            private String fieldLocale;
            private String orderTime;  //场地开放时间
            private Double rentCharge;
            private Date orderBegin;
            private Date orderEnd;*/
            for (FieldOrder fieldOrder : fieldOrders){
                FieldOrderPersonoutVO field = new FieldOrderPersonoutVO();
                Place place = placeMapper.selectByPrimaryKey(fieldOrder.getFieldId());
                field.setFieldName(place.getFieldName());
                field.setFieldLocale(place.getFieldLocale());
                field.setOrderTime(fieldOrder.getOrderTime());
                field.setRentCharge(fieldOrder.getOrderCharge());
                field.setOrderBegin(fieldOrder.getOrderBegin());
                field.setOrderEnd(fieldOrder.getOrderEnd());

                if(fieldOrder.getOrderStatus()==0){
                    field.setStatus("预约成功");
                }
                if(fieldOrder.getOrderStatus()==2){
                    field.setStatus("预约失败");
                }
                if(fieldOrder.getOrderStatus()==1){
                    field.setStatus("审核中");
                }

                fieldOrderPersonoutVOS.add(field);
            }
            return  fieldOrderPersonoutVOS;

        }else {
            return  fieldOrderPersonoutVOS;
        }

    }
}
