package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 2019/3/30 14:57
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.UserAccount;
import whu.iss.insurancesys.service.UserAccountService;

import java.util.Date;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/register")
    public ResultInfo register(UserAccount userAccount, @RequestParam("endtime")String endtime){

        ResultInfo resultInfo = new ResultInfo();
        userAccount.setStarttime(new Date());
        userAccount.setEndtime(new Date(endtime));
        int res = userAccountService.register(userAccount);
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    @PostMapping("/updateAccount")
    public ResultInfo updateAccount(UserAccount userAccount, @RequestParam("endtime")String endtime){

        ResultInfo resultInfo = new ResultInfo();
        userAccount.setEndtime(new Date(endtime));
        int res = userAccountService.update(userAccount);
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    @PostMapping("/updatePassword")
    public ResultInfo updatePassword(@RequestParam("userNo")int no,
                                     @RequestParam("username")String username,
                                     @RequestParam("password")String password){

        ResultInfo resultInfo = new ResultInfo();
        int res = userAccountService.updatePassword(no, username, password);
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    @GetMapping("/accessDenied")
    public ResultInfo accessDenied() {

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(false);
        resultInfo.setReason("forbidden");
        return resultInfo;

    }

}
