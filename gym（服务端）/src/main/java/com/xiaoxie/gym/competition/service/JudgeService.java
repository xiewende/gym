package com.xiaoxie.gym.competition.service;

import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.competition.vo.JudgeVO;

import java.util.List;

/**
 * @create 2020-06-01  18:10
 */
public interface JudgeService {

    //添加
    public Integer insertJudge(JudgeVO judgeVO);

    //修改
    public Integer updateJudge(JudgeVO judgeVO,Integer id);

    //删除
    public Integer deleteJudge(Integer id);

    //查询
    public List<Judge> selectAllJudge();

    //根据id查询
    public Judge selectJudgeById(Integer id);
}
