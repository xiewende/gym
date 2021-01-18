package com.xiaoxie.gym.competition.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxie.gym.competition.pojo.EventItems;
import com.xiaoxie.gym.competition.pojo.Events;
import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.competition.service.CompetitionService;
import com.xiaoxie.gym.competition.service.EventItemsService;
import com.xiaoxie.gym.competition.service.JudgeService;
import com.xiaoxie.gym.competition.vo.competitionVO;
import com.xiaoxie.gym.competition.vo.competitionWithOutVo;
import com.xiaoxie.gym.competition.vo.competitonOutVo;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.service.PlaceService;
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
import java.util.prefs.BackingStoreException;

/**
 * @create 2020-06-01  22:34
 */

@Api(tags = "Competition",description = "赛事管理接口")
@RestController
@CrossOrigin
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private JudgeService judgeService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private EventItemsService eventItemsService;

    //创建赛事
    @ApiOperation("创建赛事")
    @PostMapping("/creatCompetition")
    public Result creatCompetition(competitionVO competitionVO){

        //校验
        if(competitionVO.getEndTime() == null || competitionVO.getEquipment() == null
        || competitionVO.getName() == null || competitionVO.getNote()==null
        || competitionVO.getStartTime() == null || competitionVO.getTeams()==null
        || competitionVO.getEventItemName()==null || competitionVO.getJudgeName()==null
        || competitionVO.getPlaceLocal()==null || competitionVO.getPlaceName()==null){
            return Result.build(400,"数据不可以为空");
        }

        //执行插入
        Integer integer = competitionService.creatCompetition(competitionVO);
        if (integer > 0) {
            return Result.ok();
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //修改赛事
    @ApiOperation("修改赛事")
    @PostMapping("/upsateCompetition")
    @ApiImplicitParam(name = "id", value = "裁判id", required = true,
            dataType = "int", paramType = "query")
    public Result upsateCompetition(competitionVO competitionVO,Integer id){

        //校验
        if(competitionVO.getEndTime() == null || competitionVO.getEquipment() == null
                || competitionVO.getName()== null || competitionVO.getNote()==null
                || competitionVO.getStartTime() == null || competitionVO.getTeams()==null
                || competitionVO.getEventItemName()==null || competitionVO.getJudgeName()==null
                || competitionVO.getPlaceLocal()==null || competitionVO.getPlaceName()==null){
            return Result.build(400,"数据不可以为空");
        }

        //执行插入
        Integer integer = competitionService.upsateCompetition(competitionVO,id);
        if (integer > 0) {
            return Result.ok();
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //删除赛事
    @ApiOperation("删除赛事")
    @PostMapping("/deleteConpetition")
    @ApiImplicitParam(name = "id", value = "赛事id", required = true,
            dataType = "int", paramType = "query")
    public Result deleteConpetition(Integer id){

        Integer integer = competitionService.deleteConpetition(id);
        if (integer > 0) {
            return Result.build(200, "删除成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //取消赛事
    @ApiOperation("取消赛事")
    @PostMapping("/quxiaoConpetition")
    @ApiImplicitParam(name = "id", value = "赛事id", required = true,
            dataType = "int", paramType = "query")
    public Result quxiaoConpetition(Integer id){
        Integer integer = competitionService.quxiaoConpetition(id);
        if (integer > 0) {
            return Result.build(200, "取消成功！！！");
        } else {
            return Result.build(500, "系统错误！！！");
        }
    }

    //id查询
    @ApiOperation("id查询赛事")
    @PostMapping("/selectCompetitonById")
    @ApiImplicitParam(name = "id", value = "裁判id", required = true,
            dataType = "int", paramType = "query")
    public Result selectCompetitonById(Integer id){
        competitonOutVo competitonOutVo = competitionService.selectCompetitonById(id);
        if(competitonOutVo!=null){
            return Result.build(200,"OK",competitonOutVo);
        }else {
            return Result.build(400,"无数据");
        }
    }

    //根据比赛名称和状态条件查询
    @ApiOperation("根据比赛名称和状态条件查询")
    @PostMapping("/selectAllByCompetitionName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "competionname", value = "比赛名称", required = false,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "赛事状态", required = false,
                    dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "查询页码", required = true,
                    dataType = "Int", paramType = "query",defaultValue = "1")
    })
    public Result selectAllByCompetitionName(String competionname , String status,Integer pageNum){
        if("".equals(competionname)){
            competionname = null;
        }
        if("".equals(status)){
            status = null;
        }

        //实现分页
        PageHelper.startPage(pageNum, 3);


        List<Events> eventsList = competitionService.selectAllByCompetitionName(competionname, status);

        PageInfo<Events> placePageInfo = new PageInfo<>(eventsList);

        //完善属性设置
       /* private String eventItemName; //赛事项目
        private String placeName;  //场地名称
        private String placeLocal; //场地地点
        private String judgeName;  //裁判名字
        private String statusString;//状态*/
       for(Events events : eventsList){

           if(events.getStatus() == 0){
               events.setStatusString("创建成功");
           }
           if(events.getStatus() == 1){
               events.setStatusString("已取消");
           }

           Judge judge = judgeService.selectJudgeById(events.getJudgeId());
           events.setJudgeName(judge.getName());

           Place place = placeService.selectPlaceById(events.getPlaceId());
           events.setPlaceName(place.getFieldName());
           events.setPlaceLocal(place.getFieldLocale());

           EventItems eventItems = eventItemsService.selectEventItemsById(events.getEventItemId());
           events.setEventItemName(eventItems.getName());

       }
        placePageInfo.setList(eventsList);

        if(eventsList.size()>0){
            return Result.build(200,"OK",placePageInfo);
        }else {
            return Result.build(400,"无数据");
        }

    }

    //根据比赛项目查询
    @ApiOperation("根据比赛项目查询")
    @PostMapping("/selectAllByitemName")
    @ApiImplicitParam(name = "itemName", value = "裁判id", required = true,
            dataType = "string", paramType = "query")
    public Result selectAllByitemName(String itemName){
        if("".equals(itemName)){
            itemName = null;
        }
        competitionWithOutVo competitionWithOutVo = competitionService.selectAllByitemName(itemName);
        if(competitionWithOutVo !=null ){
            return Result.build(200,"OK",competitionWithOutVo);
        }else {
            return Result.build(400,"无数据");
        }

    }




}
