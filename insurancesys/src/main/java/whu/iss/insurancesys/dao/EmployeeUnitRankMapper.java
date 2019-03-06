package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeUnitRank;

public interface EmployeeUnitRankMapper {
    int insert(EmployeeUnitRank record);

    int insertSelective(EmployeeUnitRank record);
}