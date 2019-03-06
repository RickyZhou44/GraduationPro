package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ParamTypeParam;

public interface ParamTypeParamMapper {
    int insert(ParamTypeParam record);

    int insertSelective(ParamTypeParam record);
}