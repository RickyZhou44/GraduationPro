package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.NationalityParam;

public interface NationalityParamMapper {
    int insert(NationalityParam record);

    int insertSelective(NationalityParam record);
}