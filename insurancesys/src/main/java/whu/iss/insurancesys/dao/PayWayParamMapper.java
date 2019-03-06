package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.PayWayParam;

public interface PayWayParamMapper {
    int insert(PayWayParam record);

    int insertSelective(PayWayParam record);
}