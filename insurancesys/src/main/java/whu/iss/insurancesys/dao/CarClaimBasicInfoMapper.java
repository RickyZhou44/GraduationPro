package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarClaimBasicInfo;

public interface CarClaimBasicInfoMapper {
    int insert(CarClaimBasicInfo record);

    int insertSelective(CarClaimBasicInfo record);
}