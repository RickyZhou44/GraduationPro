package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeRankChangeRecord;

public interface EmployeeRankChangeRecordMapper {
    int insert(EmployeeRankChangeRecord record);

    int insertSelective(EmployeeRankChangeRecord record);
}