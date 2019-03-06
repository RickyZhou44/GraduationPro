package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.PolicyStateParam;

public interface PolicyStateParamMapper {
    int insert(PolicyStateParam record);

    int insertSelective(PolicyStateParam record);
}