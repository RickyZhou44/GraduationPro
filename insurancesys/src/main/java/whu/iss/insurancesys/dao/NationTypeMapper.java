package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.NationType;

public interface NationTypeMapper {
    int insert(NationType record);

    int insertSelective(NationType record);
}