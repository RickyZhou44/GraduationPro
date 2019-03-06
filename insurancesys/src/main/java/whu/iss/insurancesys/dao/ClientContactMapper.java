package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ClientContact;

public interface ClientContactMapper {
    int insert(ClientContact record);

    int insertSelective(ClientContact record);
}