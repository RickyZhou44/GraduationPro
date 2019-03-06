package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ContractTypeParam;

public interface ContractTypeParamMapper {
    int insert(ContractTypeParam record);

    int insertSelective(ContractTypeParam record);
}