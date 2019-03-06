package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.Client;

public interface ClientMapper {
    int insert(Client record);

    int insertSelective(Client record);
}