package com.xiaoxie.gym.place.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.service.PlaceService;
import com.xiaoxie.gym.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @create 2020-05-28  22:01
 */
@Api(tags = "place",description = "场地测试接口")
@RestController
@CrossOrigin
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @ApiOperation("hello")
    @PostMapping("/hello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fieldName", value = "场地名称", required = true,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "you", value = "场地地点", required = true,
                    dataType = "int", paramType = "query")
    })
    public String hello(String fieldName,Integer you){
        return fieldName;
    }

    //添加场地
    @ApiOperation("添加场地")
    @PostMapping("/insertPlace")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    public Result insertPlace(Place place){
        //对数据进行校验
        if(place.getFieldName() == null || "".equals(place.getFieldName())
                || place.getFieldLocale() == null || "".equals(place.getFieldLocale())
                || place.getFieldCharge() == null || "".equals(place.getFieldCharge())
                || place.getFieldManagername() == null || "".equals(place.getFieldManagername())
                || place.getFieldTime() == null || "".equals(place.getFieldTime())
                || place.getFieldManegertel() == null || "".equals(place.getFieldManegertel())){
            return Result.build(400,"数据不可以为空");
        }
        //对电话号码的校验
        String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(String.valueOf(place.getFieldManegertel()));
        if(!m.matches()){
            return Result.build(400,"电话号码输入错误！！！");
        }

        //添加默认值
        place.setDeleteTag(0);  //逻辑删除
        place.setFieldStatus(0); //场地状态

        //执行插入
        Integer integer = placeService.insertPlace(place);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该场地已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //修改场地
    @ApiOperation("修改场地")
    @PostMapping("/updatePlace")
    @ResponseBody
    public Result updatePlace(Place place){
        //对数据进行校验
        if(place.getFieldName() == null || "".equals(place.getFieldName())
                || place.getFieldLocale() == null || "".equals(place.getFieldLocale())
                || place.getFieldCharge() == null || "".equals(place.getFieldCharge())
                || place.getFieldManagername() == null || "".equals(place.getFieldManagername())
                || place.getFieldTime() == null || "".equals(place.getFieldTime())
                || place.getFieldManegertel() == null || "".equals(place.getFieldManegertel())){
            return Result.build(400,"数据不可以为空");
        }
        //对电话号码的校验
        String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(String.valueOf(place.getFieldManegertel()));
        if(!m.matches()){
            return Result.build(400,"电话号码输入错误！！！");
        }

        //添加默认值
        place.setDeleteTag(0);  //逻辑删除
        place.setFieldStatus(0); //场地状态

        //执行插入
        Integer integer = placeService.updatePlace(place);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该场地已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //查询场地 默认查询空闲状态的场地，若有输入（场地名称）条件，则条件查询，若没有，则查找全部  分页
    @PostMapping("/selectPlaceByFileName")
    @ApiOperation("查询场地")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fieldName", value = "场地名称(条件查询)", required = false,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
                    dataType = "Int", paramType = "query",defaultValue = "1")
    })
    public Result selectPlaceByFileName(String fieldName , Integer pageNum){

        //校验
        if( "".equals(fieldName)){
            fieldName=null;
        }
        //实现分页
        PageHelper.startPage(pageNum, 3);
        List<Place> placeList = placeService.selectPlaceByFileName(fieldName);
        PageInfo<Place> placePageInfo = new PageInfo<>(placeList);

        if (placeList.size() > 0) {
            return Result.build(200, "有结果！！！", placePageInfo);
        } else {
            return Result.build(400, "无场地！！！");
        }
    }

    //根据id删除课程
    @PostMapping("/deletePlace")
    @ApiOperation("删除场地")
    @ApiImplicitParam(name = "id", value = "场地id", required = true,
            dataType = "int", paramType = "query")
    public Result deletePlace(Integer id){

        System.out.println("id="+id);

        Integer integer = placeService.deletePlace(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //根据id查询场地
    @PostMapping("/selectPlaceById")
    @ApiOperation("根据id查询场地")
    @ApiImplicitParam(name = "id", value = "场地id", required = true,
            dataType = "int", paramType = "query")
    public Result selectPlaceById(Integer id){

        //查询
        Place place = placeService.selectPlaceById(id);

        if(place == null){
            return Result.build(400,"没有此场地");
        }else {
            return Result.build(200,"OK",place);
        }

    }
}
