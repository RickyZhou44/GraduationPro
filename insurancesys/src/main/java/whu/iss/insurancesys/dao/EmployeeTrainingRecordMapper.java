package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeTrainingRecord;

public interface EmployeeTrainingRecordMapper {
    int insert(EmployeeTrainingRecord record);

    int insertSelective(EmployeeTrainingRecord record);
}