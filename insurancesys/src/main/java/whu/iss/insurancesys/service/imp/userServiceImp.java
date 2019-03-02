package whu.iss.insurancesys.service.imp;

import whu.iss.insurancesys.dao.UserDao;
import whu.iss.insurancesys.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/1
 */

@Service
public class userServiceImp implements userService {
    @Autowired
    private UserDao userDao;
    @Override
    public int getUserAge(String name) {
        int age=userDao.getAge(name);
        return age;
    }
}
