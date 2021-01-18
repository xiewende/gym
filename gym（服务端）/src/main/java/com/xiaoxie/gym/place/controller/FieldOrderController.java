package com.xiaoxie.gym.place.controller;

import com.xiaoxie.gym.place.service.FieldOrderService;
import com.xiaoxie.gym.place.vo.FieldOrderPersonoutVO;
import com.xiaoxie.gym.place.vo.FieldOrderVO;
import com.xiaoxie.gym.place.vo.FieldOrderoutVO;
import com.xiaoxie.gym.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @create 2020-05-31  22:20
 */
@Api(tags = "fieldOrder",description = "场地预约")
@RestController
@CrossOrigin
@RequestMapping("/fieldOrder")
public class FieldOrderController {

    @Autowired
    private FieldOrderService fieldOrderService;

    //预约场地
    @ApiOperation("预约场地")
    @PostMapping("/fileOrder")
    public Result fileOrder(FieldOrderVO fieldOrderVO){

        //数据校验
        if(fieldOrderVO.getFieldId() == null || fieldOrderVO.getOrderBegin() == null
        || fieldOrderVO.getOrderEnd() == null || fieldOrderVO.getOrderTime() == null
        ){
            return Result.build(400,"数据不可以为空");
        }

        //执行插入
        Integer integer = fieldOrderService.fileOrder(fieldOrderVO);
        if (integer > 0) {
            return Result.ok();
        }else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //查询场地预约情况 管理员
    @ApiOperation("查询场地预约情况 管理员")
    @PostMapping("/listAllOrderField")
    @ApiImplicitParam(name = "fieldName", value = "场地名称", required = false,
            dataType = "string", paramType = "query")
    public Result listAllOrderField(String fieldName){
        if("".equals(fieldName)){
            fieldName = null;
        }

        //查询
        List<FieldOrderoutVO> fieldOrderoutVOS = fieldOrderService.listAllOrderField(fieldName);
        if(fieldOrderoutVOS.size()>0){
            return Result.build(200,"OK",fieldOrderoutVOS);
        }else {
            return Result.build(400,"没有预约！！");
        }
    }

    @ApiOperation("同意预约 管理员")
    @PostMapping("/agreefileOrder")
    @ApiImplicitParam(name = "id", value = "预约id", required = true,
            dataType = "int", paramType = "query")
    public Result agreefileOrder(Integer id){

        Integer integer = fieldOrderService.agreefileOrder(id);
        if (integer > 0) {
            return Result.ok();
        }else {
            return Result.build(500, "系统错误！！！");
        }
    }

    @ApiOperation("不同意预约 管理员")
    @PostMapping("/disagreefileOrder")
    @ApiImplicitParam(name = "id", value = "预约id", required = true,
            dataType = "int", paramType = "query")
    public Result disagreefileOrder(Integer id){

        Integer integer = fieldOrderService.disagreefileOrder(id);
        if (integer > 0) {
            return Result.ok();
        }else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //普通用户查询自己的预约情况
    @ApiOperation("普通用户查询自己的预约情况")
    @PostMapping("/selectPersonOeder")
    @ApiImplicitParam(name = "userId", value = "登陆用户id", required = false,
            dataType = "int", paramType = "query")
    public Result selectPersonOeder(Integer userId){

        List<FieldOrderPersonoutVO> fieldOrderPersonoutVOS = fieldOrderService.selectPersonOeder(userId);
        if(fieldOrderPersonoutVOS.size()>0){
            return Result.build(200, "OK",fieldOrderPersonoutVOS);
        }else {
            return Result.build(500, "无预约情况");
        }
    }



}
