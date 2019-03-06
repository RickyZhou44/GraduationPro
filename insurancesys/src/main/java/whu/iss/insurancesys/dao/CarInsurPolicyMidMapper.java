package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarInsurPolicyMid;

public interface CarInsurPolicyMidMapper {
    int insert(CarInsurPolicyMid record);

    int insertSelective(CarInsurPolicyMid record);
}