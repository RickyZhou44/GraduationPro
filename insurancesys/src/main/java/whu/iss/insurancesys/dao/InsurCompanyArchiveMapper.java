package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsurCompanyArchive;

public interface InsurCompanyArchiveMapper {
    int insert(InsurCompanyArchive record);

    int insertSelective(InsurCompanyArchive record);
}