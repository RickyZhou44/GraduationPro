package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ClientVehicle;

public interface ClientVehicleMapper {
    int insert(ClientVehicle record);

    int insertSelective(ClientVehicle record);
}