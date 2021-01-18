package com.xiaoxie.gym.competition.service.impl;

import com.xiaoxie.gym.competition.mapper.EventItemsMapper;
import com.xiaoxie.gym.competition.mapper.EventsMapper;
import com.xiaoxie.gym.competition.mapper.JudgeMapper;
import com.xiaoxie.gym.competition.pojo.*;
import com.xiaoxie.gym.competition.service.CompetitionService;
import com.xiaoxie.gym.competition.vo.competitionVO;
import com.xiaoxie.gym.competition.vo.competitionWithOutVo;
import com.xiaoxie.gym.competition.vo.competitonOutVo;
import com.xiaoxie.gym.place.mapper.FieldRentInfoMapper;
import com.xiaoxie.gym.place.mapper.PlaceMapper;
import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.pojo.Place;
import com.xiaoxie.gym.place.pojo.PlaceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @create 2020-06-01  21:44
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    private EventsMapper eventsMapper;
    @Autowired
    private EventItemsMapper eventItemsMapper;
    @Autowired
    private PlaceMapper placeMapper;
    @Autowired
    private JudgeMapper judgeMapper;
    @Autowired
    private FieldRentInfoMapper fieldRentInfoMapper;

    @Override
    public Integer creatCompetition(competitionVO competitionVO) {

        //封装数据
       /* private Integer id;
        private Integer status;
        private Integer eventItemId;
        private String name;
        private Date startTime;
        private Date endTime;
        private Integer placeId;
        private String equipment;
        private Integer judgeId;
        private String teams;
        private String note;
        private Date createTime;
        private Date updateTime;
        private Integer deleted;*/
        Events events = new Events();
        events.setStatus(0);

        //赛事项目id
        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria eventItemsExampleCriteria = eventItemsExample.createCriteria();
        eventItemsExampleCriteria.andNameEqualTo(competitionVO.getEventItemName());
        List<EventItems> eventItems = eventItemsMapper.selectByExample(eventItemsExample);
        EventItems eventItems1 = eventItems.get(0);
        events.setEventItemId(eventItems1.getId());

        events.setName(competitionVO.getName());



        //设置场地id
        PlaceExample placeExample = new PlaceExample();
        PlaceExample.Criteria placeExampleCriteria = placeExample.createCriteria();
        placeExampleCriteria.andFieldNameEqualTo(competitionVO.getPlaceName());
        placeExampleCriteria.andFieldLocaleEqualTo(competitionVO.getPlaceLocal());
        List<Place> places = placeMapper.selectByExample(placeExample);
        Place place = places.get(0);
        events.setPlaceId(place.getId());

        events.setEquipment(competitionVO.getEquipment());

        //TODO 同时场地那边设置新的场地使用
        FieldRentInfo fieldRentInfo = new FieldRentInfo();
        fieldRentInfo.setFieldId(place.getId());
        fieldRentInfo.setRentTime(place.getFieldTime());
        fieldRentInfo.setRentType(0);  //普通申请
        //设置租用状态
        fieldRentInfo.setRentStatus(3);

        //时间
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = ft.parse(competitionVO.getStartTime());
            Date endTime = ft.parse(competitionVO.getEndTime());
            events.setStartTime(startTime);
            events.setEndTime(endTime);
            fieldRentInfo.setRentBegin(startTime);
            fieldRentInfo.setRentEnd(endTime);
        }catch (Exception e){
            e.printStackTrace();
        }

        //没有删除
        fieldRentInfo.setDeleteTag(0);
        fieldRentInfo.setRentCharge(60.00);
        fieldRentInfo.setRentData(new Date());

        //插入
        fieldRentInfoMapper.insert(fieldRentInfo);

        //设置裁判id
        JudgeExample judgeExample = new JudgeExample();
        JudgeExample.Criteria judgeExampleCriteria = judgeExample.createCriteria();
        judgeExampleCriteria.andNameEqualTo(competitionVO.getJudgeName());
        List<Judge> judges = judgeMapper.selectByExample(judgeExample);
        Judge judge = judges.get(0);
        events.setJudgeId(judge.getId());

        events.setTeams(competitionVO.getTeams());
        events.setNote(competitionVO.getNote());

        events.setCreateTime(new Date());
        events.setUpdateTime(new Date());

        events.setDeleted(0);

        //执行插入
        Integer insert = eventsMapper.insert(events);

        return insert;
    }

    @Override
    public Integer upsateCompetition(competitionVO competitionVO,Integer id) {

        Events events = eventsMapper.selectByPrimaryKey(id);


        //赛事项目id
        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria eventItemsExampleCriteria = eventItemsExample.createCriteria();
        eventItemsExampleCriteria.andNameEqualTo(competitionVO.getEventItemName());
        List<EventItems> eventItems = eventItemsMapper.selectByExample(eventItemsExample);
        EventItems eventItems1 = eventItems.get(0);
        events.setEventItemId(eventItems1.getId());

        events.setName(competitionVO.getName());

        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = ft.parse(competitionVO.getStartTime());
            Date endTime = ft.parse(competitionVO.getEndTime());
            events.setStartTime(startTime);
            events.setEndTime(endTime);
        }catch (Exception e){
            e.printStackTrace();
        }

        //设置场地id
        PlaceExample placeExample = new PlaceExample();
        PlaceExample.Criteria placeExampleCriteria = placeExample.createCriteria();
        placeExampleCriteria.andFieldNameEqualTo(competitionVO.getPlaceName());
        placeExampleCriteria.andFieldLocaleEqualTo(competitionVO.getPlaceLocal());
        List<Place> places = placeMapper.selectByExample(placeExample);
        Place place = places.get(0);
        events.setPlaceId(place.getId());

        events.setEquipment(competitionVO.getEquipment());

        //设置裁判id
        JudgeExample judgeExample = new JudgeExample();
        JudgeExample.Criteria judgeExampleCriteria = judgeExample.createCriteria();
        judgeExampleCriteria.andNameEqualTo(competitionVO.getJudgeName());
        List<Judge> judges = judgeMapper.selectByExample(judgeExample);
        Judge judge = judges.get(0);
        events.setJudgeId(judge.getId());

        events.setTeams(competitionVO.getTeams());
        events.setNote(competitionVO.getNote());

        events.setUpdateTime(new Date());

        Integer i = eventsMapper.updateByPrimaryKey(events);

        return i;
    }

    @Override
    public Integer quxiaoConpetition(Integer id) {

        Events events = eventsMapper.selectByPrimaryKey(id);
        events.setStatus(1);
        Integer i = eventsMapper.updateByPrimaryKey(events);
        return i;
    }

    @Override
    public Integer deleteConpetition(Integer id) {

        Events events = eventsMapper.selectByPrimaryKey(id);
        events.setDeleted(1);

        return eventsMapper.updateByPrimaryKey(events);
    }

    @Override
    public List<Events> selectAllByCompetitionName(String competionnametionName,String status) {

        EventsExample eventsExample = new EventsExample();
        EventsExample.Criteria criteria = eventsExample.createCriteria();

        if(status != null){
            if("创建成功".equals(status)){
                criteria.andStatusEqualTo(0);
            }
            if("已取消".equals(status)){
                criteria.andStatusEqualTo(1);
            }
        }

        if(competionnametionName!= null){
            criteria.andNameLike("%"+competionnametionName+"%");
            //criteria.andNameEqualTo(competionnametionName);
        }

        criteria.andDeletedEqualTo(0);
        //执行查询
        List<Events> events = eventsMapper.selectByExample(eventsExample);

        //封装数据
       /* private Integer id;
        private String eventItemName;  //赛事项目
        private String name;   //赛事名称
        private String startTime;  //赛事开始时间
        private String endTime; //赛事结束时间
        private String placeName;  //场地名称
        private String placeLocal; //场地地点
        private String equipment;  //场地器材
        private String judgeName;  //裁判名字
        private String teams;   //队伍名字
        private String note;  //备注*/

        /*for(Events ev : events){
            competitonOutVo cv = new competitonOutVo();
            cv.setId(ev.getId());
            cv.setEventItemName(eventItemsMapper.selectByPrimaryKey(ev.getEventItemId()).getName());
            cv.setName(ev.getName());
            cv.setStartTime(ev.getStartTime());
            cv.setEndTime(ev.getEndTime());
            Place place = placeMapper.selectByPrimaryKey(ev.getPlaceId());
            cv.setPlaceName(place.getFieldName());
            cv.setPlaceLocal(place.getFieldLocale());
            cv.setEquipment(ev.getEquipment());
            cv.setJudgeName(judgeMapper.selectByPrimaryKey(ev.getJudgeId()).getName());
            cv.setTeams(ev.getTeams());
            cv.setNote(ev.getNote());

            if(ev.getStatus() == 0){
                cv.setStatus("创建成功");
            }
            if(ev.getStatus() == 1){
                cv.setStatus("已取消");
            }
            competitionVOList.add(cv);
        }*/

        return events;
    }

    @Override
    public competitionWithOutVo selectAllByitemName(String name) {

        EventsExample eventsExample = new EventsExample();
        EventsExample.Criteria criteria = eventsExample.createCriteria();


        //更具name查询id
        EventItemsExample eventItemsExample = new EventItemsExample();
        EventItemsExample.Criteria eventItemsExampleCriteria = eventItemsExample.createCriteria();
        eventItemsExampleCriteria.andNameEqualTo(name);
        List<EventItems> eventItems = eventItemsMapper.selectByExample(eventItemsExample);
        EventItems eventItems1 = eventItems.get(0);

        criteria.andEventItemIdEqualTo(eventItems1.getId());

        criteria.andDeletedEqualTo(0);

        //执行查询
        List<Events> events = eventsMapper.selectByExample(eventsExample);


        //封装返回
        competitionWithOutVo vo = new competitionWithOutVo();
        vo.setId(eventItems1.getId());
        vo.setName(eventItems1.getName());

        List<competitonOutVo> competitionOutVoList = new ArrayList<>();

        for(Events ev : events){
            competitonOutVo cv = new competitonOutVo();
            cv.setId(ev.getId());
            cv.setEventItemName(eventItemsMapper.selectByPrimaryKey(ev.getEventItemId()).getName());
            cv.setName(ev.getName());
            cv.setStartTime(ev.getStartTime());
            cv.setEndTime(ev.getEndTime());
            Place place = placeMapper.selectByPrimaryKey(ev.getPlaceId());
            cv.setPlaceName(place.getFieldName());
            cv.setPlaceLocal(place.getFieldLocale());
            cv.setEquipment(ev.getEquipment());
            cv.setJudgeName(judgeMapper.selectByPrimaryKey(ev.getJudgeId()).getName());
            cv.setTeams(ev.getTeams());
            cv.setNote(ev.getNote());

            if(ev.getStatus() == 0){
                cv.setStatus("创建成功");
            }
            if(ev.getStatus() == 1){
                cv.setStatus("已取消");
            }
            competitionOutVoList.add(cv);
        }
        vo.setCompetitonOutVo(competitionOutVoList);
        return vo;
    }

    @Override
    public competitonOutVo selectCompetitonById(Integer id) {

        Events ev = eventsMapper.selectByPrimaryKey(id);
        competitonOutVo cv = new competitonOutVo();
        cv.setId(ev.getId());
        cv.setEventItemName(eventItemsMapper.selectByPrimaryKey(ev.getEventItemId()).getName());
        cv.setName(ev.getName());
        cv.setStartTime(ev.getStartTime());
        cv.setEndTime(ev.getEndTime());
        Place place = placeMapper.selectByPrimaryKey(ev.getPlaceId());
        cv.setPlaceName(place.getFieldName());
        cv.setPlaceLocal(place.getFieldLocale());
        cv.setEquipment(ev.getEquipment());
        cv.setJudgeName(judgeMapper.selectByPrimaryKey(ev.getJudgeId()).getName());
        cv.setTeams(ev.getTeams());
        cv.setNote(ev.getNote());

        if(ev.getStatus() == 0){
            cv.setStatus("创建成功");
        }
        if(ev.getStatus() == 1){
            cv.setStatus("已取消");
        }

        return cv;
    }
}
