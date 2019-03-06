package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.RankParam;

public interface RankParamMapper {
    int insert(RankParam record);

    int insertSelective(RankParam record);
}