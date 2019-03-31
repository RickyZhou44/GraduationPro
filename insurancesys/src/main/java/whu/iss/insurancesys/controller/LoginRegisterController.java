package whu.iss.insurancesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.MailData;
import whu.iss.insurancesys.service.LoginRegisterService;
import whu.iss.insurancesys.util.EmailUtil;
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
  @RequestMapping("/bb")
    public Object send(){
      ResultInfo resultInfo=new ResultInfo();
      String code= RickUtil.getRandomCode();
      String email="819894286@qq.com";
      Date date=new Date();
      MailData mailData=new MailData();
      mailData.setContent(code);
      mailData.setReciever(email);
      mailData.setDate(date);
      loginRegisterService.sendEmail(mailData);
      return resultInfo;
    }
}
