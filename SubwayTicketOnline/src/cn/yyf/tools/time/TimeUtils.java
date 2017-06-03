package cn.yyf.tools.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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


    public static String getNextDayByTime(String startTime) {

        if (startTime.trim().isEmpty() || startTime == "") {
            return "";
        }

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date next = sdf.parse(startTime);

            Calendar c = Calendar.getInstance();

            c.setTime(next);

            c.add(Calendar.DAY_OF_MONTH, 1);

            next = c.getTime();

            return sdf.format(next);

        } catch (Exception e) {

            e.printStackTrace();

            return "";

        }

    }
}
