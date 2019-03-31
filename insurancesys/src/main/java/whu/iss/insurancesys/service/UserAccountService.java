package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 2019/3/30 12:52
 * Notes:
 * */

import whu.iss.insurancesys.entity.UserAccount;

public interface UserAccountService {

    int register(UserAccount userAccount);

    int update(UserAccount userAccount);

    int updatePassword(int no, String username, String password);

    UserAccount loginByUsername(String username);

}
