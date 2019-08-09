package org.QGStudio.util;

/**
 * @description 对时间进行切割
 * @author < a href=" ">郭沛</ a>
 * @date 2019-08-08 21:36
 */
public class TimeUtil {

    /**
     * 针对数据库的Date类型的数据进行切割，得到的是去除秒的时间
     * @param time
     * @return
     */
    public static String cuttingTime(String time) {
        String time1 = time.split(":")[0];
        String time2 = time.split(":")[1];
        time = time1 + time2;
        return time;
    }

}
