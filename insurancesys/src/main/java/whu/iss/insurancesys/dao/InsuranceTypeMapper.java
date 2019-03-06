package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsuranceType;

public interface InsuranceTypeMapper {
    int insert(InsuranceType record);

    int insertSelective(InsuranceType record);
}