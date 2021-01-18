package com.xiaoxie.gym.competition.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.competition.service.JudgeService;
import com.xiaoxie.gym.competition.vo.JudgeVO;
import com.xiaoxie.gym.utils.GetPhoneUrl;
import com.xiaoxie.gym.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @create 2020-06-01  18:22
 */

@Api(tags = "Judge",description = "裁判管理接口")
@RestController
@CrossOrigin
@RequestMapping("/judge")
public class JudgeController {

    @Autowired
    private JudgeService judgeService;

    @Value("${file-save-path}")
    private String fileSavePath;

    //添加
    @ApiOperation("添加裁判")
    @PostMapping("/insertJudge")
    //@ApiImplicitParam(name = "file",value = "单个文件，",paramType = "formData",required = true,dataType = "file")
    public Result insertJudge(JudgeVO judgeVO,MultipartFile file, HttpServletRequest request ){

        //校验数据
        if(judgeVO.getName() == null || judgeVO.getProfile() == null || judgeVO.getSpecialities() == null){
            return Result.build(400,"数据不可以为空");
        }
        //获取图片的路径
        String phone_url = GetPhoneUrl.GetPhoneUrlfrom(file, request, fileSavePath);

        judgeVO.setPhotoUrl(phone_url);

        //执行插入
        Integer integer = judgeService.insertJudge(judgeVO);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该裁判已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    @ApiOperation("修改裁判")
    @PostMapping("/updateJudge")
    @ApiImplicitParam(name = "id", value = "裁判id", required = true,
            dataType = "int", paramType = "query")
    public Result updateJudge(JudgeVO judgeVO, Integer id,MultipartFile file, HttpServletRequest request){

        //校验数据
        if(judgeVO.getName() == null || judgeVO.getProfile() == null || judgeVO.getSpecialities() == null){
            return Result.build(400,"数据不可以为空");
        }
        //获取图片的路径
        if(file!=null){
            String phone_url = GetPhoneUrl.GetPhoneUrlfrom(file, request, fileSavePath);
            judgeVO.setPhotoUrl(phone_url);
        }else {
            judgeVO.setPhotoUrl(null);
        }


        //修改
        Integer integer = judgeService.updateJudge(judgeVO, id);
        if (integer > 0) {
            return Result.ok();
        } else if (integer == 0) {
            return Result.build(400, "该裁判已经存在！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }

    }

    //删除
    @ApiOperation("删除裁判")
    @PostMapping("/deleteJudge")
    @ApiImplicitParam(name = "id", value = "裁判id", required = true,
            dataType = "int", paramType = "query")
    public Result deleteJudge(Integer id){

        Integer integer = judgeService.deleteJudge(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    @ApiOperation("查询全部裁判")
    @PostMapping("/selectAllJudge")
    @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
            dataType = "Int", paramType = "query",defaultValue = "1")
    public Result selectAllJudge(Integer pageNum){

        //实现分页
        PageHelper.startPage(pageNum, 4);
        List<Judge> judges = judgeService.selectAllJudge();
        PageInfo<Judge> placePageInfo = new PageInfo<>(judges);

        if (judges.size() > 0) {
            return Result.build(200, "有结果！！！", placePageInfo);
        } else {
            return Result.build(400, "无数据！！！");
        }
    }

    //根据id查询
    @ApiOperation("根据id查询裁判")
    @PostMapping("/selectJudgeById")
    @ApiImplicitParam(name = "id", value = "裁判id", required = true,
            dataType = "int", paramType = "query")
    public Result selectJudgeById(Integer id){

        Judge judge = judgeService.selectJudgeById(id);
        if (judge!=null) {
            return Result.build(200, "OK",judge);
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }



}
