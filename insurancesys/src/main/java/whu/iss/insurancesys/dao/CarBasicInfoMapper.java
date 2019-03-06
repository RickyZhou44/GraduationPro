package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarBasicInfo;

public interface CarBasicInfoMapper {
    int insert(CarBasicInfo record);

    int insertSelective(CarBasicInfo record);
}