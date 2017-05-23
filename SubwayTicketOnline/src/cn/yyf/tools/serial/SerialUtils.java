package cn.yyf.tools.serial;

import cn.yyf.tools.time.TimeUtils;
import java.util.Random;

/**
 * Created by DonaldY on 2017/5/22.
 */
public class SerialUtils {

    public SerialUtils() {

    }

    public static String serialNumber(String uuid) {

        StringBuilder buffer = new StringBuilder();

        //时间戳后8位
        String time = TimeUtils.currentTime().trim().replace(" ", "").replace(":","").substring(8);
        buffer.append(time);

        //随机4位
        Random random = new Random();
        int MAXN = 9999;
        int MIXN = 1000;
        int randNum = random.nextInt(MAXN) % (MAXN - MIXN) + MIXN;
        buffer.append(randNum);

        //用户后4位
        for (char ss : uuid.substring(28).toCharArray()) {
            buffer.append(ss % 10);
        }

        return buffer.toString();
    }

}
