package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.Contract;

public interface ContractMapper {
    int insert(Contract record);

    int insertSelective(Contract record);
}