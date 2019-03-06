package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.DepartmentInfo;

public interface DepartmentInfoMapper {
    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);
}