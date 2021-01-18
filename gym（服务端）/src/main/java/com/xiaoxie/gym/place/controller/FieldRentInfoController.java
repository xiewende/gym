package com.xiaoxie.gym.place.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.service.FieldRentInfoService;
import com.xiaoxie.gym.place.service.PlaceService;
import com.xiaoxie.gym.place.util.GetUser;
import com.xiaoxie.gym.place.util.User;
import com.xiaoxie.gym.place.vo.FieldRentInfoVO;
import com.xiaoxie.gym.place.vo.FieldRentInfooutVO;
import com.xiaoxie.gym.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @create 2020-05-29  23:52
 */
@Api(tags = "fieldRentInfo",description = "场地租用信息接口")
@RestController
@CrossOrigin
@RequestMapping("/fieldRentInfo")
public class FieldRentInfoController {

    @Autowired
    private FieldRentInfoService fieldRentInfoService;
    @Autowired
    private PlaceService placeService;

    //设置场地特殊状态
    @PostMapping("/setPlaceEspecialUser")
    @ApiOperation("设置场地的特殊使用")
    public Result setPlaceEspecialUser (FieldRentInfoVO fieldRentInfoVO){

        //校验数据
        if(fieldRentInfoVO.getFieldName() == null || fieldRentInfoVO.getRentBegin() == null
          || fieldRentInfoVO.getRentEnd() == null || fieldRentInfoVO.getRentType() == null
          || fieldRentInfoVO.getUserName() == null || fieldRentInfoVO.getFieldLocal() == null
          || fieldRentInfoVO.getUserTel() == null  || fieldRentInfoVO.getRentTime() == null
          || "".equals(fieldRentInfoVO.getFieldName()) ||  "".equals(fieldRentInfoVO.getRentBegin())
           || "".equals(fieldRentInfoVO.getRentEnd()) ||  "".equals(fieldRentInfoVO.getRentType())
           || "".equals(fieldRentInfoVO.getUserName()) ||  "".equals(fieldRentInfoVO.getFieldLocal())
          || "".equals(fieldRentInfoVO.getUserTel()) ||  "".equals(fieldRentInfoVO.getRentTime())
        ){
            return Result.build(400,"数据不可以为空");
        }
        //对电话号码的校验
        String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(fieldRentInfoVO.getUserTel());
        if(!m.matches()){
            return Result.build(400,"电话号码输入错误！！！");
        }

        //执行插入
        Integer integer = fieldRentInfoService.setPlaceEspecialUser(fieldRentInfoVO);
        if (integer > 0) {
            return Result.ok();
        }else {
            return Result.build(500, "系统错误！！！");
        }

    }

    //查询场地使用情况  条件输入
    @PostMapping("/getAllFieldRentInfo")
    @ApiOperation("查询场地使用情况  条件输入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "场地名称", required = false,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场地使用类型", required = false,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
                    dataType = "Int", paramType = "query",defaultValue = "1")
    })
    public Result getAllFieldRentInfo(String fileName, String type,Integer pageNum){

        if("".equals(fileName)){
            fileName = null;
        }
        if("".equals(type)){
            type = null;
        }

        //实现分页
        PageHelper.startPage(pageNum,3);

        List<FieldRentInfo> allFieldRentInfo = fieldRentInfoService.getAllFieldRentInfo(fileName, type);
        PageInfo<FieldRentInfo> placePageInfo = new PageInfo<>(allFieldRentInfo);

        //完善属性
        for(FieldRentInfo info : allFieldRentInfo){

            info.setFieldTime(info.getRentTime());

            Place place = placeService.selectPlaceById(info.getFieldId());
            info.setFieldName(place.getFieldName());
            info.setFieldLocale(place.getFieldLocale());

            if(info.getRentStatus() == 1){   //租用中 1，已预约 2，特殊状态 3，完成预约 4
                info.setFieldStatus("租用中");
            }
            if(info.getRentStatus() == 2){
                info.setFieldStatus("已预约");
            }
            if(info.getRentStatus() == 3){
                info.setFieldStatus("特殊状态");
            }
            if(info.getRentStatus() == 4){
                info.setFieldStatus("完成预约");
            }

            if(info.getRentType()== 0){
                info.setRentTypeString("普通申请");
            }
            if(info.getRentType()== 1){
                info.setRentTypeString("上课用地");
            }
            if(info.getRentType()== 2){
                info.setRentTypeString("校队用地");
            }System.out.println("id="+info.getTentuserId());

            //TODO  用户名和电话应该是查询得知的

            if(info.getTentuserId() ==null || "".equals(info.getTentuserId())){
                info.setUserName("xiaoxie");
                info.setUserTel("17876208191");
            }else {
                User user = GetUser.getUser(info.getTentuserId());
                if(user!=null){
                    info.setUserName(user.getName());
                    info.setUserTel(user.getPhone());
                }else {
                    info.setUserName("xiaoxie");
                    info.setUserTel("17876208191");
                }
            }


        }

        placePageInfo.setList(allFieldRentInfo);

        if(allFieldRentInfo.size()>0){
            return Result.build(200,"OK",placePageInfo);
        }else {
            return Result.build(400,"没有数据！！！");
        }

    }

    //根据id删除使用详情
    @PostMapping("/deleteFieldRentInfo")
    @ApiOperation("根据id删除使用详情")
    @ApiImplicitParam(name = "id", value = "场地id", required = true,
            dataType = "int", paramType = "query")
    public Result deleteFieldRentInfo(Integer id){

        System.out.println("id="+id);

        Integer integer = fieldRentInfoService.deleteFieldRentInfo(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }


}
