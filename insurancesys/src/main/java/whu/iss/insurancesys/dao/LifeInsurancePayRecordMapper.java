package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.LifeInsurancePayRecord;

public interface LifeInsurancePayRecordMapper {
    int insert(LifeInsurancePayRecord record);

    int insertSelective(LifeInsurancePayRecord record);
}