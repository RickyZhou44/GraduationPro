package whu.iss.insurancesys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JPZUtil {

    public static final Logger logger = LoggerFactory.getLogger(JPZUtil.class);

    /**
     * @param length 字符串长度
     * @return 随机的字符串
     */
    public static String getRandomName(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     *
     * @param length
     * @return
     */
    public static String getFixLenthNumber(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取区间内的日期
     *
     * @param startDate
     * @param endDate
     * @param pattern   制定格式，如yyyy-MM-dd
     * @return
     */
    public static Date getRandomDate(String startDate, String endDate, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date start = simpleDateFormat.parse(startDate);
            Date end = simpleDateFormat.parse(endDate);
            if (start.getTime() > end.getTime()) {
                return null;
            }
            long res = random(start.getTime(), end.getTime());
            date = new Date(res);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return date;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
