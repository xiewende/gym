package com.xiaoxie.gym.competition.service;

import com.xiaoxie.gym.competition.pojo.Events;
import com.xiaoxie.gym.competition.vo.competitionVO;
import com.xiaoxie.gym.competition.vo.competitionWithOutVo;
import com.xiaoxie.gym.competition.vo.competitonOutVo;

import java.util.List;

/**
 * @create 2020-06-01  21:32
 */
public interface CompetitionService {

    //创建赛事
    public Integer creatCompetition(competitionVO competitionVO);

    //修改赛事
    public Integer upsateCompetition(competitionVO competitionVO,Integer id);

    //取消赛事
    public Integer quxiaoConpetition(Integer id);

    //删除赛事
    public Integer deleteConpetition(Integer id);

    //根据比赛名称和状态条件查询
    public List<Events> selectAllByCompetitionName(String competionname , String status);  //

    //根据比赛项目查询
    public competitionWithOutVo selectAllByitemName(String itemName);  //

    //id查询
    public competitonOutVo selectCompetitonById(Integer id);
}
