package whu.iss.insurancesys.util;

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
}
