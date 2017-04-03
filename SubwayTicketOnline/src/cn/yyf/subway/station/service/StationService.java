package cn.yyf.subway.station.service;

import cn.yyf.subway.station.dao.StationDao;
import cn.yyf.subway.station.domain.Station;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Donald on 2016/8/24.
 */
public class StationService {
    private StationDao stationDao = new StationDao();

    public List<Station> findStationByCid(String cid){
        try {
            return stationDao.findStationByCid(cid);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
