package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.OperateParam;

public interface OperateParamMapper {
    int insert(OperateParam record);

    int insertSelective(OperateParam record);
}