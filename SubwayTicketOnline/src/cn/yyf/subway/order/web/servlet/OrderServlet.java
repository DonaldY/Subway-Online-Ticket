package cn.yyf.subway.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.order.domain.Order;
import cn.yyf.subway.order.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by DonaldY on 2017/5/4.
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderService();

    public String createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order formOrder = CommonUtils.toBean(req.getParameterMap(), Order.class);

        String msg = validateOrder(formOrder, req.getSession());

        if (msg != "" && msg.length() != 0) {
            return "f:/jsps/main.jsp";
        }

        System.out.println(formOrder);

        /**
         * 1. 添加用户id
         * 2. 设置状态， 0 为 未购买
         * 3. 设置二维码大小图，序列号，均在购完票后。
         */
        formOrder.setUid(req.getSession().getId());

        formOrder.setStatus(0);




        return "f:/jsps/order/desc.jsp";
    }

    private String validateOrder(Order order, HttpSession session) {

        if (order.getCity() == "" || order.getCity().length() == 0) {
            return "City error!";
        }
        
        if (order.getFromPath() == "" || order.getFromPath().length() == 0) {
            return "From path error!";
        }
        
        if (order.getToPath() == "" || order.getToPath().length() == 0) {
            return "To path error!";
        }
        
        if (order.getFromStation() == "" || order.getFromStation().length() == 0) {
            return "from station error!";
        }

        if (order.getToStation() == "" || order.getToStation().length() == 0) {
            return "To station error!";
        }

        if (order.getStartTime() == "" || order.getStartTime().length() == 0
            ) {
            //
            return "Date error!";
        }

        if (order.getTicketNum() <= 0 || order.getTicketNum() > 8) {
            return "Ticker number error!";
        }

        Map<String, List<String>> mapList = orderService.getMapByCity(order.getCity());

        List<String> toList = mapList.get(order.getToPath());

        List<String> fromList = mapList.get(order.getFromPath());

        if (toList == null || fromList == null) {
            return "Path error!";
        }

        if (!toList.contains(order.getToStation()) || !fromList.contains(order.getFromStation())) {
            return "Station error!";
        }

        return "";

    }

}
