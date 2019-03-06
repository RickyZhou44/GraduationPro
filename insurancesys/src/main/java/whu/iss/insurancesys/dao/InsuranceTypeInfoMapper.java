package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsuranceTypeInfo;

public interface InsuranceTypeInfoMapper {
    int insert(InsuranceTypeInfo record);

    int insertSelective(InsuranceTypeInfo record);
}