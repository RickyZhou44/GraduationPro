package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ClientTypeParam;

public interface ClientTypeParamMapper {
    int insert(ClientTypeParam record);

    int insertSelective(ClientTypeParam record);
}