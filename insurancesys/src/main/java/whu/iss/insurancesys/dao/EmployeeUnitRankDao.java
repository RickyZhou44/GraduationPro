package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeUnitRank;

public interface EmployeeUnitRankDao {
    int insert(EmployeeUnitRank record);

    int insertSelective(EmployeeUnitRank record);

    int update(EmployeeUnitRank record);
}