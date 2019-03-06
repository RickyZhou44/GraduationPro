package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.PayTypeParam;

public interface PayTypeParamMapper {
    int insert(PayTypeParam record);

    int insertSelective(PayTypeParam record);
}