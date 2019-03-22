package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeBasicInformation;

public interface EmployeeBasicInformationMapper {
    int insert(EmployeeBasicInformation record);

    int insertSelective(EmployeeBasicInformation record);


}