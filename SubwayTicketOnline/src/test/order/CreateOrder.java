package test.order;

import cn.itcast.commons.CommonUtils;
import cn.yyf.tools.serial.SerialUtils;
import cn.yyf.tools.time.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by DonaldY on 2017/5/22.
 */
public class CreateOrder {

    public static void main(String[] args) {

        Random random = new Random();

        String str[] = new String[]{"迈皋桥站","红山动物园站","南京站","新模范马路站","玄武门站","彭鼓楼站","珠江路站","新街口站",
            "张府园站", "三山街站", "中华门站", "安德门站", "天隆寺站", "软件大道站", "花神庙站","南京南站", "双龙大道站","河定桥站","胜太路站",
            "百家湖站", "小龙湾站" ,"竹山路站","天印大道站","龙眠大道站","南医大·江苏经贸学院","南京交院站","中国药科大学站"};

        String str2[] = new String[]{"1号线", "2号线", "3号线", "4号线", "10号线", "s1号线", "s8号线"};

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < 5 ; ++i) {

            StringBuilder buffer = new StringBuilder();

            Date date = new Date();
            String time = format.format(date);

            buffer.append("insert into s_order(oid, orderTime, startTime, endTime, city, fromPath, toPath, " +
                "fromStation, toStation, image_w, " +
                "image_b, status, serialNum, ticketNum, price, totalPrice, uid) values ('");

            buffer.append(CommonUtils.uuid());
            buffer.append("','");

            buffer.append(TimeUtils.currentTime());
            buffer.append("','");

            buffer.append(time);
            buffer.append("','");

            buffer.append(time);
            buffer.append("','");

            buffer.append("南京");
            buffer.append("','");

            buffer.append("1号线");
            buffer.append("','");

            buffer.append("1号线");
            buffer.append("','");

            buffer.append(str[random.nextInt(27)]);
            buffer.append("','");

            buffer.append(str[random.nextInt(27)]);
            buffer.append("','");

            buffer.append("/QR-Code_img/default_w.png");
            buffer.append("','");

            buffer.append("/QR-Code_img/default_b.png");
            buffer.append("','");

            buffer.append(3);
            buffer.append("','");

            buffer.append(SerialUtils.serialNumber("454426502254499F837A59356812C485"));
            buffer.append("','");

            int num = random.nextInt(8) + 1;

            buffer.append(num);
            buffer.append("','");

            buffer.append(4);
            buffer.append("','");

            buffer.append(4 * num);
            buffer.append("','");

            buffer.append("454426502254499F837A59356812C485");

            buffer.append("');");

            System.out.println(buffer.toString());
        }


    }

}
