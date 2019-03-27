package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeBasicInformation;

/**
 * 员工基本信息Dao
 */
public interface EmployeeBasicInformationDao {
    int insert(EmployeeBasicInformation record);

    int insertSelective(EmployeeBasicInformation record);
}