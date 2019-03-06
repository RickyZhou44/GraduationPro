package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeArchineInfo;

public interface EmployeeArchineInfoMapper {
    int insert(EmployeeArchineInfo record);

    int insertSelective(EmployeeArchineInfo record);
}