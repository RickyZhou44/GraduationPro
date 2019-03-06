package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.UserAccount;

public interface UserAccountMapper {
    int insert(UserAccount record);

    int insertSelective(UserAccount record);
}