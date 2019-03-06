package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CommissionSystemParam;

public interface CommissionSystemParamMapper {
    int insert(CommissionSystemParam record);

    int insertSelective(CommissionSystemParam record);
}