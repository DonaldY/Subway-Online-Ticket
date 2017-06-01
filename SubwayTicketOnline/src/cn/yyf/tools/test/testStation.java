package cn.yyf.tools.test;

import cn.yyf.tools.station.ShortestPath;
import cn.yyf.tools.station.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by DonaldY on 2017/5/19.
 */
public class testStation {

    ShortestPath shortestPath;

    @Before
    public void before() {
        this.shortestPath = new ShortestPath();
    }

    @Test
    public void test() {

        String str = "[南京南站,花神庙站,软件大道站,天隆寺站,安德门站,小行站,中胜站,元通站,雨润大街站,油坊桥站]";

        String str1 = "[南京南站,花神庙站,软件大道站]";

        Assert.assertEquals(str, toListString(this.shortestPath.getShortestPath(new Station("南京南站"), new Station
            ("油坊桥站")
        )));

        Assert.assertEquals(str1, toListString(this.shortestPath.getShortestPath(new Station("南京南站"), new Station
            ("软件大道站")
        )));

    }

    @Test
    public void testException() {

        Station fromStation = new Station("南京紫金站");
        Station toStation = new Station("仙林中心站");

        Assert.assertEquals("[]", toListString(this.shortestPath.getShortestPath(fromStation, toStation)));


    }

    private String toListString(LinkedHashSet<Station> stations) {

        StringBuffer buffer = new StringBuffer();

        buffer.append("[");

        Iterator iterator = stations.iterator();

        while (iterator.hasNext()) {

            buffer.append((iterator.next()).toString());

            if (iterator.hasNext()) {

                buffer.append(",");

            }

        }

        buffer.append("]");

        return buffer.toString();

    }


    @Test
    public void testFromStationLinkStations() {

        String str = "[翠屏山站,花神庙站,双龙大道站,明发广场站,宏运大道站]";

        Assert.assertEquals(str, toArrString(this.shortestPath.getLinkedStations(new Station("南京南站"))));


    }

    private String toArrString(List<Station> list) {

        ArrayList<Station> arrayList = (ArrayList<Station>) list;

        StringBuffer buffer = new StringBuffer();

        buffer.append("[");

        for (int i = 0; i < arrayList.size(); ++ i) {

            buffer.append(arrayList.get(i).getName());

            if (i + 1 < arrayList.size()) {
                buffer.append(",");
            }

        }

        buffer.append("]");

        return buffer.toString();
    }


}
