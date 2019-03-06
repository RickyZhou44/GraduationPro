package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ClaimSettle;

public interface ClaimSettleMapper {
    int insert(ClaimSettle record);

    int insertSelective(ClaimSettle record);
}