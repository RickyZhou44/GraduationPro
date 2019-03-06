package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarInsurancePolicy;

public interface CarInsurancePolicyMapper {
    int insert(CarInsurancePolicy record);

    int insertSelective(CarInsurancePolicy record);
}