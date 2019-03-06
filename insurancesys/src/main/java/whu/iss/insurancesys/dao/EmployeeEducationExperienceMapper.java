package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EmployeeEducationExperience;

public interface EmployeeEducationExperienceMapper {
    int insert(EmployeeEducationExperience record);

    int insertSelective(EmployeeEducationExperience record);
}