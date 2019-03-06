package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarInsuranceType;

public interface CarInsuranceTypeMapper {
    int insert(CarInsuranceType record);

    int insertSelective(CarInsuranceType record);
}