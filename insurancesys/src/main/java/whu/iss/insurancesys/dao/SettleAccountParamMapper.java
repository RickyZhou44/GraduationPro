package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.SettleAccountParam;

public interface SettleAccountParamMapper {
    int insert(SettleAccountParam record);

    int insertSelective(SettleAccountParam record);
}