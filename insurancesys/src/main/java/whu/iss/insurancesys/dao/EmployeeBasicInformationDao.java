package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeBasicInformation;

public interface EmployeeBasicInformationDao {
    int insert(EmployeeBasicInformation record);

    int insertSelective(EmployeeBasicInformation record);

    int update(EmployeeBasicInformation record);
}