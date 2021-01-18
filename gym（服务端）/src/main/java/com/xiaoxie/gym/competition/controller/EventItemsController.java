package com.xiaoxie.gym.competition.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.competition.pojo.EventItems;
import com.xiaoxie.gym.competition.service.EventItemsService;
import com.xiaoxie.gym.place.pojo.Place;
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

/**
 * @create 2020-06-01  17:55
 */

@Api(tags = "eventItems",description = "赛事项目名称")
@RestController
@CrossOrigin
@RequestMapping("/eventItems")
public class EventItemsController {

    @Autowired
    private EventItemsService eventItemsService;

    //添加
    @ApiOperation("添加赛事项目")
    @PostMapping("/addEventItems")
    @ApiImplicitParam(name = "name", value = "赛事项目名称", required = true,
            dataType = "string", paramType = "query")
    public Result addEventItems(String name){
        if(name == null || "".equals(name)){
            return Result.build(400,"数据不可以为空");
        }

        //执行插入
        Integer integer = eventItemsService.addEventItems(name);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该赛事项目已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }


    //修改
    @ApiOperation("修改赛事项目")
    @PostMapping("/updateEventItems")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "赛事项目名称", required = true,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "赛事项目名称id", required = true,
                    dataType = "int", paramType = "query")
    })
    public Result updateEventItems(String name, Integer id){

        if(name == null || "".equals(name)){
            return Result.build(400,"数据不可以为空");
        }

        //修改
        Integer integer = eventItemsService.updateEventItems(name, id);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该赛事项目已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //删除
    @ApiOperation("删除赛事项目")
    @PostMapping("/deleteEventItems")
    @ApiImplicitParam(name = "id", value = "赛事项目名称id", required = true,
            dataType = "int", paramType = "query")
    public Result deleteEventItems(Integer id){

        Integer integer = eventItemsService.deleteEventItems(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    @ApiOperation("id查询赛事项目")
    @PostMapping("/selectEventItemsById")
    @ApiImplicitParam(name = "id", value = "赛事项目名称id", required = true,
            dataType = "int", paramType = "query")
    public Result selectEventItemsById(Integer id){

        EventItems eventItems = eventItemsService.selectEventItemsById(id);
        if(eventItems!=null){
            return Result.build(200, "OK",eventItems);
        }else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //查询
    @ApiOperation("查询赛事项目")
    @PostMapping("/seleEventItemsAll")
    @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
            dataType = "Int", paramType = "query",defaultValue = "1")
    public Result seleEventItemsAll( Integer pageNum){


        //实现分页
        PageHelper.startPage(pageNum, 3);
        List<EventItems> eventItems = eventItemsService.seleEventItemsAll();
        PageInfo<EventItems> placePageInfo = new PageInfo<>(eventItems);


        if(eventItems.size()>0){
            return Result.build(200,"OK",placePageInfo);
        }else {
            return Result.build(400,"无数据！！");
        }

    }

}
