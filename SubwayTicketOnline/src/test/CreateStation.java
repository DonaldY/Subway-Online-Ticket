package test;

import cn.itcast.commons.CommonUtils;

/**
 * Created by Donald on 2016/8/19.
 */
public class CreateStation {
    public static void main(String[] args) {


        //String strl = "insert into s_category(cid,cname,pid,`desc`,orderBy) values ('"+CommonUtils.uuid()+"', '南京', NULL, '江苏南京', '1')";
        //System.out.println(strl);
/*
        String str[] = new String[]{"1号线", "2号线", "3号线", "10号线", "s1号线", "s8号线"};
        String str2[] = new String[]{"地铁1号线途径栖霞区、鼓楼区、玄武区、秦淮区、雨花台区和江宁区，线路北起迈皋桥站，沿南京主城区中轴线一路南下",
        "南京地铁2号线按建设启动时间分为一期工程和东延工程两段。2号线一期起于河西新区的油坊桥，止于紫金山麓的马群，线路贯穿南京主城区的东西向中轴线",
        "3号线全长44.9公里，线路途径浦口区、鼓楼区、玄武区、秦淮区、雨花台区和江宁区。共设置29座车站，其中林场站为高架站，其余28座车站均为地下站",
        "地铁10号线途径浦口区、建邺区和雨花台区，线路西起雨山路站，跨越长江进入河西新城，东至安德门站，线路总长21.6千米",
        "南京至高淳城际快速轨道南京南站至禄口机场段（简称S1号线）南起禄口机场，经禄口新城、东善桥～秣陵片区、东山副城西侧，止于南京南站",
        "南京至天长城际快速轨道泰山新村至金牛湖段（简称S8号线）南起泰山新村站，经过桥北地区、浦口沿江、大厂、六合，北至金牛湖站，途径浦口区和六合 区"};
        StringBuilder buffer;
        for(int i = 0; i < 6; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_category(cid,cname,pid,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(str[i]);
            buffer.append("','");
            buffer.append("CD64A72D1FEF4E51BB7EF188F8E19545");
            buffer.append("','");
            buffer.append(str2[i]);
            buffer.append("',");
            buffer.append(i + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/
        /*String str[] = new String[]{"迈皋桥站","红山动物园站","南京站","新模范马路站","玄武门站","彭鼓楼站","珠江路站","新街口站",
        "张府园站", "三山街站", "中华门站", "安德门站", "天隆寺站", "软件大道站", "花神庙站","南京南站", "双龙大道站","河定桥站","胜太路站",
        "百家湖站", "小龙湾站" ,"竹山路站","天印大道站","龙眠大道站","南医大·江苏经贸学院","南京交院站","中国药科大学站"};

        StringBuilder buffer;
        for(int i = 0; i < 27; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(str[i]);
            buffer.append("','");
            buffer.append("D513BD22B68C4A89B11AB91909ABC250");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/


        /*String twoLineStr = "油坊桥站,雨润大街站,元通站,奥体东站,兴隆大街站,集庆门大街站,云锦路站,莫愁湖站,汉中门站," +
            "上海路站,新街口站,大行宫站,西安门站,明故宫站,苜蓿园站,下马坊站,孝陵卫站,钟灵街站,马群站,金马路站,仙鹤门站," +
            "学则路站,仙林中心站,羊山公园站,南大仙林校区站,经天路站";
        String [] twoLineArr = twoLineStr.split(",");

        StringBuilder buffer;
        for(int i = 0; i < twoLineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(twoLineArr[i]);
            buffer.append("','");
            buffer.append("A2912C5040E94285A87E158B26190011");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 27 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/


        /*String threeLineStr = "林场站,星火路站,东大成贤学院站,泰冯路站,天润城站,柳洲东路站,上元门站,五塘广场站,小市站," +
            "南京站,南京林业大学·新庄站,鸡鸣寺站,浮桥站,大行宫站,常府街站,夫子庙站,武定门站,雨花门站,卡子门站,大明路站," +
            "明发广场站,南京南站,宏运大道站,胜太西路站,天元西路站,九龙湖站,诚信大道站,东大九龙湖校区站,秣周东路站";
        String [] threeLineArr = threeLineStr.split(",");

        StringBuilder buffer;
        for(int i = 0; i < threeLineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(threeLineArr[i]);
            buffer.append("','");
            buffer.append("52767911A81645F68088652BD81CC37A");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 53 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/

        /*String fourLineStr = "龙江站,草场门站,云南路站,鼓楼站,鸡鸣寺站,九华山站,岗子村站,蒋王庙站,王家湾站,聚宝山站,徐庄站,金马路站" +
            "汇通路站,灵山站,东流站,孟北站,桦墅站,仙林湖站";
        String [] fourLineArr = fourLineStr.split(",");

        StringBuilder buffer;
        for(int i = 0; i < fourLineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(fourLineArr[i]);
            buffer.append("','");
            buffer.append("C8C39AF1A00B44FDA32B5AC3C020ECD6");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 82 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/

        /*String tenLineStr = "雨山路站,文德路站,龙华路站,南京工业大学站,浦口万汇城站,临江站,江心洲站,绿博园站,梦都大街站," +
            "奥体中心站,元通站,中胜站,小行站,安德门站";
        String[] tenLineArr = tenLineStr.split(",");
        StringBuilder buffer;
        for(int i = 0; i < tenLineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(tenLineArr[i]);
            buffer.append("','");
            buffer.append("F2F3FD598A07439BAE56D0D39CFCD45F");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 99 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/

        /*String s1LineStr = "南京南站,翠屏山站,河海大学·佛城西路站,吉印大道站,正方中路站,翔宇路北站,翔宇路南站,禄口机场站";
        String[] s1LineArr = s1LineStr.split(",");
        StringBuilder buffer;
        for(int i = 0; i < s1LineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(s1LineArr[i]);
            buffer.append("','");
            buffer.append("33398E13FFC54EA4806D5CBBF60AF360");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 113 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }*/

        String s8LineStr = "泰山新村站,泰冯路站,高新开发区站,信息工程大学站,卸甲甸站,大厂站,葛塘站,长芦站,化工园站," +
            "六合开发区站,龙池站,雄州站,凤凰山公园站,方州广场站,沈桥站,八百桥站,金牛湖站";
        String[] s8LineArr = s8LineStr.split(",");

        StringBuilder buffer;
        for(int i = 0; i < s8LineArr.length ; ++i){
            buffer = new StringBuilder();
            buffer.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            buffer.append(CommonUtils.uuid());
            buffer.append("','");
            buffer.append(s8LineArr[i]);
            buffer.append("','");
            buffer.append("365B36E856F9417A8C4A39405B0FB5CF");
            buffer.append("',");
            buffer.append(2 * i);
            buffer.append(",'");
            buffer.append("");
            buffer.append("',");
            buffer.append(i + 121 + 1);
            buffer.append(");");
            System.out.println(buffer);
        }


    }
}
