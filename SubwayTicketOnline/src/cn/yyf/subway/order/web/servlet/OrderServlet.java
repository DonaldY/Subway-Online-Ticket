package cn.yyf.subway.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.order.domain.Order;
import cn.yyf.subway.order.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by DonaldY on 2017/5/4.
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderService();

    public String createOrder(HttpServletRequest request, HttpServletResponse response) {

        //封装订单
        Order formOrder = CommonUtils.toBean(request.getParameterMap(), Order.class);

        //校验订单
        String msg = validateOrder(formOrder, request.getSession());

        if (msg != "" && msg.length() != 0) {
            return "f:/jsps/main.jsp";
        }



        return null;
    }

    private String validateOrder(Order order, HttpSession session) {

        return null;

    }

}
