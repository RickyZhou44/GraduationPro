package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsurCompanyBasicInfo;

public interface InsurCompanyBasicInfoMapper {
    int insert(InsurCompanyBasicInfo record);

    int insertSelective(InsurCompanyBasicInfo record);
}