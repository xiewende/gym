package com.xiaoxie.gym.place.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.place.pojo.Announcement;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.service.AnnouncementService;
import com.xiaoxie.gym.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @create 2020-05-30  0:22
 */

@Api(tags = "announcement",description = "场地公告")
@RestController
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    //添加公告
    @PostMapping("insertAnnouncement")
    @ApiOperation("添加公告")
    public Result insertAnnouncement(Announcement announcement){
        //校验
        if(announcement.getAnnouncementAuthor() == null || "".equals(announcement.getAnnouncementAuthor())
        || announcement.getAnnouncementConten() == null || "".equals(announcement.getAnnouncementConten())
        || announcement.getAnnouncementTitle() == null || "".equals(announcement.getAnnouncementTitle())){
            return Result.build(400,"数据不可以为空");
        }

        //填充不用前端传参地数据
        announcement.setAnnouncementDelelte(0);
        announcement.setAnnouncementTime(new Date());

        //执行插入
        Integer integer = announcementService.insertAnnouncement(announcement);
        if (integer > 0) {
            return Result.ok();
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //查询全部公告,管理员
    @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
            dataType = "Int", paramType = "query",defaultValue = "1")
    @PostMapping("/listAllAnnouncement")
    @ApiOperation("查询全部公告,管理员")
    public Result listAllAnnouncement(Integer pageNum){

        //实现分页
        PageHelper.startPage(pageNum, 3);
        List<Announcement> announcements = announcementService.listAllAnnouncement();
        PageInfo<Announcement> placePageInfo = new PageInfo<>(announcements);

        if (announcements.size() > 0) {
            return Result.build(200, "有结果！！！", placePageInfo);
        } else {
            return Result.build(400, "查本版本目前无课程！！！");
        }
    }

    //删除公告
    @PostMapping("/deleteAnnouncement")
    @ApiOperation("删除公告")
    @ApiImplicitParam(name = "id", value = "场地id", required = true,
            dataType = "int", paramType = "query")
    public Result deleteAnnouncement(Integer id){

        Integer integer = announcementService.deleteAnnouncement(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //学生端查询展示最近的一个公告
    @ApiOperation("学生端查询展示最近的一个公告")
    @PostMapping("selectByRencent")
    public Result selectByRencent(){
        Announcement announcement = announcementService.selectByRencent();
        if(announcement == null){
            return Result.build(400, "最近没有公告");
        }else {
            return Result.build(200,"查询成功",announcement);
        }
    }




}
