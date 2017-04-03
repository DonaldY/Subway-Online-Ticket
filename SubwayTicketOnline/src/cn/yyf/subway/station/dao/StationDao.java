package cn.yyf.subway.station.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.yyf.subway.category.domain.Category;
import cn.yyf.subway.station.domain.Station;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Donald on 2016/8/24.
 */
public class StationDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Station> findStationByCid(String cid) throws SQLException {
        String sql = "select * from s_station where cid=? order by orderBy";
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), cid);
        return toStationList(mapList);
    }

    /***
     * 把多个map(List<Map>) 映射成多Station(List<Station>)
     * @param mapList
     * @return
     */
    private List<Station> toStationList(List<Map<String, Object>> mapList){
        List<Station> stationList = new ArrayList<Station>();
        for(Map<String, Object> map : mapList){
            Station c = toStation(map);
            stationList.add(c);
        }
        return stationList;
    }

    /**
     * 把一个map中的数据映射到Station中
     * @param map
     * @return
     */
    private Station toStation(Map<String, Object> map){
		/*
		 * map{cid: xxx, cname:xx, pid:xx, desc:xx, orderBy:xx}
		 * Station{cid:xx,cname:xx, parent:xx, desc:xx}
		 */
        Station station = CommonUtils.toBean(map, Station.class);
        String cid = (String)map.get("cid");

        Category parent = new Category();
        parent.setCid(cid);
        station.setParent(parent);

        return station;
    }
}
