package whu.iss.insurancesys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.entity.MailData;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/28
 */
//封装邮件的相关
@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender sender;
    public  void send(MailData data){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("yxj873534617@163.com");
        //接收者
        mainMessage.setTo(data.getReciever());
        //发送的标题
        mainMessage.setSubject("您的验证码如下：");
        //发送的内容
        mainMessage.setText(data.getContent());
        sender.send(mainMessage);
        System.out.println("发送成功");
    }
}
