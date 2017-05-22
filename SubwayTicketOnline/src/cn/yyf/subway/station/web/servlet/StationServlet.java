package cn.yyf.subway.station.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.station.domain.Station;
import cn.yyf.subway.station.service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Donald on 2016/8/24.
 */
@WebServlet(name = "StationServlet")
public class StationServlet extends BaseServlet {

    private StationService stationService = new StationService();

    public String ajaxFindStation(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException{
		/**
		 * 1.获取pid
		 * 2.通过pid查询出所有2级分类
		 * 3.把List<station>转换成json，输出给客户端
		 */
        String cid = req.getParameter("cid");
        List<Station> stationList = stationService.findStationByCid(cid);
        String json = toJson(stationList);
        resp.getWriter().print(json);
        return null;
    }

    //[{"sid":"123", "sname":"456"},{"sid":"789", "sname":963}]
    private String toJson(List<Station> stationList){
        StringBuilder sb = new StringBuilder("[");
        int length = stationList.size();
        for (int i = 0; i < length; ++i){
            sb.append(toJson(stationList.get(i)));
            if (i < length - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //{"sid":"123", "sname":"456"}
    private String toJson(Station station){
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"sid\":\"").append(station.getSid()).append("\",");
        sb.append("\"sname\":\"").append(station.getSname()).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
