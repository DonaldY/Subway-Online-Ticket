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

    public String createOrder(HttpServletRequest req, HttpServletResponse resp) {

        //封装订单
        Order formOrder = CommonUtils.toBean(req.getParameterMap(), Order.class);

        //uid
        formOrder.setUid(req.getSession().getId());
        //序列号

        //设置状态
        formOrder.setStatus(0);

        //校验订单
        String msg = validateOrder(formOrder, req.getSession());

        if (msg != "" && msg.length() != 0) {
            return "f:/jsps/main.jsp";
        }


        return "f:/jsps/order/desc.jsp";
    }

    private String validateOrder(Order order, HttpSession session) {

        if (order.getCity() == "" || order.getCity().length() == 0) {
            return "城市错误";
        }
        
        if (order.getFromPath() == "" || order.getFromPath().length() == 0) {
            return "出发路线错误";
        }
        
        if (order.getToPath() == "" || order.getToPath().length() == 0) {
            return "目的地路线错误";
        }
        
        if (order.getFromStation() == "" || order.getFromStation().length() == 0) {
            return "出发站点错误";
        }

        if (order.getToStation() == "" || order.getToStation().length() == 0) {
            return "目的地站点错误";
        }

        if (order.getOrderTime() == "" || order.getOrderTime().length() == 0) {
            return "日期错误";
        }

        if (order.getCount() <= 0 || order.getCount() > 8) {
            return "数量错误";
        }

        //数据库验证

        return null;

    }

}
