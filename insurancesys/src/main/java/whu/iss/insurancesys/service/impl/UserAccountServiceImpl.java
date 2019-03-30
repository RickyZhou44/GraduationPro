package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 2019/3/30 13:00
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.UserAccountDao;
import whu.iss.insurancesys.entity.UserAccount;
import whu.iss.insurancesys.service.UserAccountService;
import whu.iss.insurancesys.util.MD5Util;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountDao userAccountDao;

    public int register(UserAccount userAccount) {

        userAccount.setPassword(MD5Util.encode2hex(userAccount.getPassword()));
        return userAccountDao.insert(userAccount);

    }

    //基本信息修改
    public int update(UserAccount userAccount) {

        return userAccountDao.update(userAccount);

    }

    //密码修改
    public int updatePassword(int no, String username, String password){

        return userAccountDao.updatePassword(no, username, MD5Util.encode2hex(password));

    }

    public UserAccount loginByUsername(String username) {

        return userAccountDao.getByUserName(username);

    }

}
