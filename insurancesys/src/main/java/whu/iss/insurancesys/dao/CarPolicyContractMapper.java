package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarPolicyContract;

public interface CarPolicyContractMapper {
    int insert(CarPolicyContract record);

    int insertSelective(CarPolicyContract record);
}