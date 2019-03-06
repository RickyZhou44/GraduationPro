package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.FeeRateParam;

public interface FeeRateParamMapper {
    int insert(FeeRateParam record);

    int insertSelective(FeeRateParam record);
}