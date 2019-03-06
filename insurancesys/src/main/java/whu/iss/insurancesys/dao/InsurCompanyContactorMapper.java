package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsurCompanyContactor;

public interface InsurCompanyContactorMapper {
    int insert(InsurCompanyContactor record);

    int insertSelective(InsurCompanyContactor record);
}