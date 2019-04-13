package whu.iss.insurancesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.MailData;
import whu.iss.insurancesys.service.LoginRegisterService;
import whu.iss.insurancesys.util.RickUtil;

import java.util.Date;


/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/28
 */
//用于处理网页的登陆和注册业务控制
    @RestController
public class LoginRegisterController {
      @Autowired
      LoginRegisterService loginRegisterService;

      //发送邮箱验证
  @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public Object sendEmail(@RequestParam("email")String email){
      ResultInfo resultInfo=new ResultInfo();
      String code= RickUtil.getRandomCode();
      Date date=new Date();
      MailData mailData=new MailData();
      mailData.setContent(code);
      mailData.setReciever(email);
      mailData.setDate(date);
      loginRegisterService.sendEmail(mailData);
      resultInfo.setResult(true);
      return resultInfo;
    }
    //注册操作
  @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
  public Object register(@RequestParam("user")String user,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("validate")String validate){
    ResultInfo resultInfo=new ResultInfo();
    //首先判断验证码是否有效
    Date date=new Date();
    if(loginRegisterService.registerIf(email,validate,date)){
        loginRegisterService.addAccount(user,email,password,date);
        resultInfo.setResult(true);
        return resultInfo;
    }
    else {
      resultInfo.setResult(false);
      resultInfo.setReason("验证码错误或超时");
    }
    return resultInfo;
  }
    //进行登陆操作
    @RequestMapping(value = "/loginPage",method = RequestMethod.POST)
  public Object login(@RequestParam("user")String user,@RequestParam("password")String password){
    ResultInfo resultInfo=loginRegisterService.login(user,password);
    return resultInfo;
    }

}
