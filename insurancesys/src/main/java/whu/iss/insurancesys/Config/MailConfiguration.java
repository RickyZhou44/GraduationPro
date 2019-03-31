package whu.iss.insurancesys.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Scanner;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/28
 */
@Configuration
public class MailConfiguration {
    @Bean
    public JavaMailSenderImpl JavaMainSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("yxj873534617@163.com");
        mailSender.setPort(25);
        mailSender.setPassword("yxj12345678");
        mailSender.setProtocol("smtp");
        return mailSender;
    }
//    @Bean
//    public  JavaMailSenderImpl JavaMailSender(){
//            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//            mailSender.setHost("smtp.163.com");
//            mailSender.setUsername("XXXXX@163.com"); 
//            mailSender.setPassword("*******");
//         return  mailSender;
//    }
    public static void  main(String[]strings){
        int[]num={3,21,34,45,56,67,78,89,90};
        int low=0;
        int high=num.length-1;
        Scanner scanner=new Scanner(System.in);
        int key=scanner.nextInt();
        int mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if(num[mid]==key){
                System.out.println("啦啦啦"+mid);
                return;
            }
            else if(num[mid]<key){
                low=mid+1;
            }

            else {
                high=mid-1;
            }
        }
        System.out.println("查找失败");
    }

}
