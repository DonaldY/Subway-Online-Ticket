package cn.yyf.tools.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by DonaldY on 2017/6/3.
 */
public class TimeTest {

    @Test
    public void test() {

        String dateStr = "2017-8-31";

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date date = sdf.parse(dateStr);

            System.out.println("before : " + sdf.format(date));

            Calendar c = Calendar.getInstance();

            c.setTime(date);

            c.add(Calendar.DAY_OF_MONTH, 2);

            date = c.getTime();

            System.out.println("after  : " + sdf.format(date));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
