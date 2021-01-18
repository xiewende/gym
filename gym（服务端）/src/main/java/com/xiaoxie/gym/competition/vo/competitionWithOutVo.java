package com.xiaoxie.gym.competition.vo;

import java.util.List;

/**
 * @create 2020-06-01  21:40
 */
public class competitionWithOutVo {

    private Integer id;
    private String name;

    private List<competitonOutVo> competitonOutVo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.xiaoxie.gym.competition.vo.competitonOutVo> getCompetitonOutVo() {
        return competitonOutVo;
    }

    public void setCompetitonOutVo(List<com.xiaoxie.gym.competition.vo.competitonOutVo> competitonOutVo) {
        this.competitonOutVo = competitonOutVo;
    }
}
