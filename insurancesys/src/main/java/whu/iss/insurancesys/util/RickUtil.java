package whu.iss.insurancesys.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/21
 */
//此类用于封装一些常用的方法
public class RickUtil {

    //此方法用于去掉字符串后面的回车符
    public static String removeEsc(String sts) {
        if (sts.endsWith("\r")) {
            return sts.substring(0, sts.length() - 1);
        }
        else{
            return sts;
        }
    }
    //用于处理年次字符串格式问题
    public static String yearTimesFormat(String str){
        if(str.length()==3){
            str="0"+str;
            return str;
        }
        else {
            return str;
        }
    }
    //用于计算年龄的工具
    public static int getAge(Date date){
        Calendar cal = Calendar.getInstance();
        if(cal.before(date)){
            return 0;
        }
        int yearNow=cal.get(Calendar.YEAR);
        int monthNow=cal.get(Calendar.MONTH);
        int dayNow=cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(date);
        int yearBirth=cal.get(Calendar.YEAR);
        int monthBirth=cal.get(Calendar.MONTH);
        int dayBith=cal.get(Calendar.DAY_OF_MONTH);
        int age=yearNow-yearBirth;
        if(monthNow<=monthBirth){
            if(monthBirth==monthNow){
                if(dayNow<dayBith){age--;}

            }
            else {
                age--;
            }
        }
        return 0;
    }
//    生成随机的6位随机数用于作为验证码
    public static String getRandomCode(){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }
}
