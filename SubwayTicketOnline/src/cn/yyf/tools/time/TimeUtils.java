package cn.yyf.tools.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DonaldY on 2017/5/22.
 */
public class TimeUtils {

    public TimeUtils() {

    }

    public static String currentTime() {

        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return timeFormat.format(new Date());
    }


}
