package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsurCompanyBranchRelated;

public interface InsurCompanyBranchRelatedMapper {
    int insert(InsurCompanyBranchRelated record);

    int insertSelective(InsurCompanyBranchRelated record);
}