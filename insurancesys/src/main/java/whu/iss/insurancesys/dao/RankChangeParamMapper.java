package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.RankChangeParam;

public interface RankChangeParamMapper {
    int insert(RankChangeParam record);

    int insertSelective(RankChangeParam record);
}