package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.EducationLevelParam;

public interface EducationLevelParamMapper {
    int insert(EducationLevelParam record);

    int insertSelective(EducationLevelParam record);
}