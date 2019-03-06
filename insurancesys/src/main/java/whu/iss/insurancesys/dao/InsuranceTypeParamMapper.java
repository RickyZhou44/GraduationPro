package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsuranceTypeParam;

public interface InsuranceTypeParamMapper {
    int insert(InsuranceTypeParam record);

    int insertSelective(InsuranceTypeParam record);
}