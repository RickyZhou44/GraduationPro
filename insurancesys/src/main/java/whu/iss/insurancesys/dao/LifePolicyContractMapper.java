package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.LifePolicyContract;

public interface LifePolicyContractMapper {
    int insert(LifePolicyContract record);

    int insertSelective(LifePolicyContract record);
}