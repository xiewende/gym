package com.xiaoxie.gym.competition.service.impl;

import com.xiaoxie.gym.competition.mapper.JudgeMapper;
import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.competition.pojo.JudgeExample;
import com.xiaoxie.gym.competition.service.JudgeService;
import com.xiaoxie.gym.competition.vo.JudgeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @create 2020-06-01  18:13
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Autowired
    private JudgeMapper judgeMapper;

    @Override
    public Integer insertJudge(JudgeVO judgeVO) {
        //判断是否存在
        JudgeExample judgeExample = new JudgeExample();
        JudgeExample.Criteria criteria = judgeExample.createCriteria();
        criteria.andNameEqualTo(judgeVO.getName());
        List<Judge> judges = judgeMapper.selectByExample(judgeExample);
        if (judges.size()>0){
            return 0;
        }

        //插入
        Judge judge = new Judge();

        judge.setSpecialities(judgeVO.getSpecialities());
        judge.setProfile(judgeVO.getProfile());
        judge.setPhotoUrl(judgeVO.getPhotoUrl());
        judge.setName(judgeVO.getName());
        judge.setUpdateTime(new Date());
        judge.setCreateTime(new Date());
        judge.setDeleted(0);


        return judgeMapper.insert(judge);
    }

    @Override
    public Integer updateJudge(JudgeVO judgeVO, Integer id) {

        Judge judge = judgeMapper.selectByPrimaryKey(id);

        if(judgeVO.getPhotoUrl()!=null){
            judge.setPhotoUrl(judgeVO.getPhotoUrl());
        }

        judge.setProfile(judgeVO.getProfile());
        judge.setSpecialities(judgeVO.getSpecialities());
        judge.setUpdateTime(new Date());
        if(judge.getName().equals(judgeVO.getName())){
            return judgeMapper.updateByPrimaryKey(judge);
        }

        judge.setName(judgeVO.getName());

        //判断是否存在
        JudgeExample judgeExample = new JudgeExample();
        JudgeExample.Criteria criteria = judgeExample.createCriteria();
        criteria.andNameEqualTo(judgeVO.getName());
        List<Judge> judges = judgeMapper.selectByExample(judgeExample);
        if (judges.size()>0){
            return 0;
        }

        return judgeMapper.updateByPrimaryKey(judge);
    }

    @Override
    public Integer deleteJudge(Integer id) {

        Judge judge = judgeMapper.selectByPrimaryKey(id);
        judge.setDeleted(1);
        return judgeMapper.updateByPrimaryKey(judge);
    }

    @Override
    public List<Judge> selectAllJudge() {
        JudgeExample judgeExample = new JudgeExample();
        JudgeExample.Criteria criteria = judgeExample.createCriteria();
        criteria.andDeletedEqualTo(0);
        return judgeMapper.selectByExample(judgeExample);
    }

    @Override
    public Judge selectJudgeById(Integer id) {

        Judge judge = judgeMapper.selectByPrimaryKey(id);

        return judge;
    }
}
