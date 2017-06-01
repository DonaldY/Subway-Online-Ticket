package cn.yyf.tools.station;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DonaldY on 2017/5/19.
 */
public class NjBuilder {

    private final List<Station> oneLine = new ArrayList<Station>();//1号线
    private final List<Station> twoLine = new ArrayList<Station>();//2号线
    private final List<Station> threeLine = new ArrayList<Station>();//3号线
    private final List<Station> fourLine = new ArrayList<Station>();//4号线
    private final List<Station> tenLine = new ArrayList<Station>();//10号线
    private final List<Station> s1Line = new ArrayList<Station>();//s1号线
    private final List<Station> s8Line = new ArrayList<Station>();//s8号线
    private final Set<List<Station>> lineSet = new HashSet<List<Station>>();
    private int totalStaion = 0;

    private volatile static NjBuilder instance;

    public NjBuilder() {
        //////////////////////////////////1号线////////////////////////////////////////
        String oneLineStr = "迈皋桥站,红山动物园站,南京站,新模范马路站,玄武门站,鼓楼站,珠江路站,新街口站,张府园站," +
            "三山街站,中华门站,安德门站,天隆寺站,软件大道站,花神庙站,南京南站,双龙大道站,河定桥站,胜太路站,百家湖站," +
            "小龙湾站,竹山路站,天印大道站,龙眠大道站,南医大·江苏经贸学院站,南京交院站,中国药科大学站";
        String [] oneLineArr = oneLineStr.split(",");

        /*int [] oneArr = {0, 0, 1, 0, 0, 1, 0, 1, 0,
            0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < oneArr.length; ++i) {

            oneLine.add(new Station(oneLineArr[i], oneArr[i]));

        }*/
        for(String s : oneLineArr){
            oneLine.add(new Station(s));
        }
        for(int i = 0;i < oneLine.size();i ++){
            if(i < oneLine.size() - 1){
                oneLine.get(i).next = oneLine.get(i + 1);
                oneLine.get(i + 1).prev = oneLine.get(i);
            }
        }

        //////////////////////////////////2号线////////////////////////////////////////
        String twoLineStr = "油坊桥站,雨润大街站,元通站,奥体东站,兴隆大街站,集庆门大街站,云锦路站,莫愁湖站,汉中门站," +
            "上海路站,新街口站,大行宫站,西安门站,明故宫站,苜蓿园站,下马坊站,孝陵卫站,钟灵街站,马群站,金马路站,仙鹤门站," +
            "学则路站,仙林中心站,羊山公园站,南大仙林校区站,经天路站";
        String [] twoLineArr = twoLineStr.split(",");

        /*int [] twoArr = {0, 0, 1, 0, 0, 0, 0, 0, 0
            , 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0
            , 0, 0, 0, 0, 0};

        for (int i = 0; i < twoArr.length; ++i) {

            twoLine.add(new Station(twoLineArr[i], twoArr[i]));

        }*/

        for(String s : twoLineArr){
            twoLine.add(new Station(s));
        }
        for(int i = 0;i < twoLine.size(); i++){
            if(i<twoLine.size() - 1){
                twoLine.get(i).next = twoLine.get(i + 1);
                twoLine.get(i + 1).prev = twoLine.get(i);
            }
        }

        //////////////////////////////////3号线////////////////////////////////////////
        String threeLineStr = "林场站,星火路站,东大成贤学院站,泰冯路站,天润城站,柳洲东路站,上元门站,五塘广场站,小市站," +
            "南京站,南京林业大学·新庄站,鸡鸣寺站,浮桥站,大行宫站,常府街站,夫子庙站,武定门站,雨花门站,卡子门站,大明路站," +
            "明发广场站,南京南站,宏运大道站,胜太西路站,天元西路站,九龙湖站,诚信大道站,东大九龙湖校区站,秣周东路站";
        String [] threeLineArr = threeLineStr.split(",");

        /*int [] threeArr = {0, 0, 0, 1, 0, 0, 0, 0, 0
            , 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0
            , 0, 1, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < threeArr.length; ++i) {

            threeLine.add(new Station(threeLineArr[i], threeArr[i]));

        }*/

        for(String s : threeLineArr){
            threeLine.add(new Station(s));
        }
        for(int i = 0;i < threeLine.size(); i++){
            if(i<threeLine.size() - 1){
                threeLine.get(i).next = threeLine.get(i + 1);
                threeLine.get(i + 1).prev = threeLine.get(i);
            }
        }

        //////////////////////////////////4号线////////////////////////////////////////
        String fourLineStr = "龙江站,草场门站,云南路站,鼓楼站,鸡鸣寺站,九华山站,岗子村站,蒋王庙站,王家湾站,聚宝山站,徐庄站,金马路站" +
            "汇通路站,灵山站,东流站,孟北站,桦墅站,仙林湖站";
        String [] fourLineArr = fourLineStr.split(",");

        /*int [] fourArr = {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1
            , 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < fourArr.length; ++i) {

            fourLine.add(new Station(fourLineArr[i], fourArr[i]));

        }*/

        for (String s : fourLineArr) {
            fourLine.add(new Station(s));
        }
        for (int i = 0; i < fourLine.size(); ++i) {
            if (i < fourLine.size() - 1) {
                fourLine.get(i).next = fourLine.get(i + 1);
                fourLine.get(i + 1).prev = fourLine.get(i);
            }
        }

        //////////////////////////////////10号线////////////////////////////////////////
        String tenLineStr = "雨山路站,文德路站,龙华路站,南京工业大学站,浦口万汇城站,临江站,江心洲站,绿博园站,梦都大街站," +
            "奥体中心站,元通站,中胜站,小行站,安德门站";
        String[] tenLineArr = tenLineStr.split(",");

        for(String s : tenLineArr){
            tenLine.add(new Station(s));
        }

        /*int [] tenArr = {0, 0, 0, 0, 0, 0, 0, 0, 0
            , 0, 1, 0, 0, 1};

        for (int i = 0; i < tenArr.length; ++i) {

            tenLine.add(new Station(tenLineArr[i], tenArr[i]));

        }*/

        for(int i = 0;i < tenLine.size();i++){
            if(i<tenLine.size()-1){
                tenLine.get(i).next = tenLine.get(i + 1);
                tenLine.get(i + 1).prev = tenLine.get(i);
            }
        }

        //////////////////////////////////s1号线////////////////////////////////////////
        String s1LineStr = "南京南站,翠屏山站,河海大学·佛城西路站,吉印大道站,正方中路站,翔宇路北站,翔宇路南站,禄口机场站";
        String[] s1LineArr = s1LineStr.split(",");

        /*int [] s1Arr  = {1, 0, 0, 0, 0, 0, 0, 4};

        for (int i = 0; i < s1Arr.length; ++i) {

            s1Line.add(new Station(s1LineArr[i], s1Arr[i]));

        }*/

        for(String s : s1LineArr){
            s1Line.add(new Station(s));
        }
        for(int i =0;i<s1Line.size();i++){
            if(i<s1Line.size() - 1){
                s1Line.get(i).next = s1Line.get(i + 1);
                s1Line.get(i + 1).prev = s1Line.get(i);
            }
        }

        //////////////////////////////////s8号线////////////////////////////////////////
        String s8LineStr = "泰山新村站,泰冯路站,高新开发区站,信息工程大学站,卸甲甸站,大厂站,葛塘站,长芦站,化工园站," +
            "六合开发区站,龙池站,雄州站,凤凰山公园站,方州广场站,沈桥站,八百桥站,金牛湖站";
        String[] s8LineArr = s8LineStr.split(",");

        /*int [] s8Arr = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0
            , 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < s8Arr.length; ++i) {

            s8Line.add(new Station(s8LineArr[i], s8Arr[i]));

        }*/


        for(String s : s8LineArr){
            s8Line.add(new Station(s));
        }
        for(int i = 0 ; i < s8Line.size(); i++){
            if(i<s8Line.size() - 1){
                s8Line.get(i).next = s8Line.get(i+1);
                s8Line.get(i + 1).prev = s8Line.get(i);
            }
        }

        lineSet.add(oneLine);
        lineSet.add(twoLine);
        lineSet.add(threeLine);
        lineSet.add(fourLine);
        lineSet.add(tenLine);
        lineSet.add(s1Line);
        lineSet.add(s8Line);
        totalStaion = oneLine.size() + twoLine.size() + threeLine.size() + fourLine.size() + tenLine.size() + s1Line.size() +
            s8Line.size();

    }

    public static NjBuilder getInstance() {

        if (instance == null) {
            synchronized (NjBuilder.class) {
                if (instance == null) {
                    instance = new NjBuilder();
                }
            }
        }

        return instance;
    }

    public int getTotalStaion() {
        return this.totalStaion;
    }

    public Set<List<Station>> getLineSet() {
        return this.lineSet;
    }


}
