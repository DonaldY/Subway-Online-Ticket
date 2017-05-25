package cn.yyf.tools.station;

import java.util.LinkedHashSet;

/**
 * Created by DonaldY on 2017/5/24.
 */
public class PathBuilder {

    public static LinkedHashSet<Station> getShortestPath(String fromStation, String toStation) {
        return new ShortestPath().getShortestPath(new Station(fromStation), new Station(toStation));
    }

}
