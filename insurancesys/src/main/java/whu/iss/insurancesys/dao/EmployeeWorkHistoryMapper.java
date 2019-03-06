package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeWorkHistory;

public interface EmployeeWorkHistoryMapper {
    int insert(EmployeeWorkHistory record);

    int insertSelective(EmployeeWorkHistory record);
}