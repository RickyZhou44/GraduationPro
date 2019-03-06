package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.LifeInsurancePolicy;

public interface LifeInsurancePolicyMapper {
    int insert(LifeInsurancePolicy record);

    int insertSelective(LifeInsurancePolicy record);
}