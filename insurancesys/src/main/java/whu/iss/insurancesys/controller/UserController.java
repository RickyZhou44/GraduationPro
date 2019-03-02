package whu.iss.insurancesys.controller;

import whu.iss.insurancesys.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/1
 */
@RestController
public class UserController {
    @Autowired
    private userService userService;
    @RequestMapping("user")
    String index(){
        String name="rick";
        int age=userService.getUserAge(name);
        return "my age is "+age;
       // return name+"'s age is "+userDao.getUserAge(name);
    }
}
