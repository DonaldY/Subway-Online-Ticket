package Test;

import cn.itcast.commons.CommonUtils;

/**
 * Created by Donald on 2016/8/19.
 */
public class createStation {
    public static void main(String[] args) {
        //System.out.println(CommonUtils.uuid());

        //insert into s_book(sid, sname, cid, sitePrice, desc, orderBy)values ('', '', '', '', '', '');
        //String strl = "insert into s_category(cid,cname,pid,`desc`,orderBy) values ('"+CommonUtils.uuid()+"', '南京', NULL, '江苏南京', '1')";
        //System.out.println(strl);
/*
        String str[] = new String[]{"1号线", "2号线", "3号线", "10号线", "s1号线", "s2号线"};
        String str2[] = new String[]{"地铁1号线途径栖霞区、鼓楼区、玄武区、秦淮区、雨花台区和江宁区，线路北起迈皋桥站，沿南京主城区中轴线一路南下",
        "南京地铁2号线按建设启动时间分为一期工程和东延工程两段。2号线一期起于河西新区的油坊桥，止于紫金山麓的马群，线路贯穿南京主城区的东西向中轴线",
        "3号线全长44.9公里，线路途径浦口区、鼓楼区、玄武区、秦淮区、雨花台区和江宁区。共设置29座车站，其中林场站为高架站，其余28座车站均为地下站",
        "地铁10号线途径浦口区、建邺区和雨花台区，线路西起雨山路站，跨越长江进入河西新城，东至安德门站，线路总长21.6千米",
        "南京至高淳城际快速轨道南京南站至禄口机场段（简称S1号线）南起禄口机场，经禄口新城、东善桥～秣陵片区、东山副城西侧，止于南京南站",
        "南京至天长城际快速轨道泰山新村至金牛湖段（简称S8号线）南起泰山新村站，经过桥北地区、浦口沿江、大厂、六合，北至金牛湖站，途径浦口区和六合 区"};
        StringBuilder sb;
        for(int i = 0; i < 6; ++i){
            sb = new StringBuilder();
            sb.append("insert into s_category(cid,cname,pid,`desc`,orderBy) values ('");
            sb.append(CommonUtils.uuid());
            sb.append("','");
            sb.append(str[i]);
            sb.append("','");
            sb.append("CD64A72D1FEF4E51BB7EF188F8E19545");
            sb.append("','");
            sb.append(str2[i]);
            sb.append("',");
            sb.append(i + 1);
            sb.append(");");
            System.out.println(sb);
        }*/
        String str[] = new String[]{"迈皋桥站","红山动物园站","南京站","新模范马路站","玄武门站","彭鼓楼站","珠江路站","新街口站",
        "张府园站", "三山街站", "中华门站", "安德门站", "天隆寺站", "软件大道站", "花神庙站","南京南站", "双龙大道站","河定桥站","胜太路站",
        "百家湖站", "小龙湾站" ,"竹山路站","天印大道站","龙眠大道站","南医大·江苏经贸学院","南京交院站","中国药科大学站"};

        StringBuilder sb;
        for(int i = 0; i < 27; ++i){
            sb = new StringBuilder();
            sb.append("insert into s_station(sid,sname,cid,sitePrice,`desc`,orderBy) values ('");
            sb.append(CommonUtils.uuid());
            sb.append("','");
            sb.append(str[i]);
            sb.append("','");
            sb.append("D513BD22B68C4A89B11AB91909ABC250");
            sb.append("',");
            sb.append(2 * i);
            sb.append(",'");
            sb.append("");
            sb.append("',");
            sb.append(i + 1);
            sb.append(");");
            System.out.println(sb);
        }

    }
}
