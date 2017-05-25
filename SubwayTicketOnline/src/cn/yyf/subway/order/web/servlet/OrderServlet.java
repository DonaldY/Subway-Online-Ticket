package cn.yyf.subway.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.order.domain.Order;
import cn.yyf.subway.order.service.OrderService;
import cn.yyf.subway.pager.PageBean;
import cn.yyf.subway.user.domain.User;
import cn.yyf.tools.station.PathBuilder;
import cn.yyf.tools.station.Station;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


/**
 * Created by DonaldY on 2017/5/4.
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderService();

    public String confirmOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order formOrder = CommonUtils.toBean(req.getParameterMap(), Order.class);

        LinkedHashSet<Station> list = PathBuilder.getShortestPath(formOrder.getFromStation(), formOrder.getToStation());

        double price = calulatePriceByList(list);

        formOrder.setPrice(price);

        formOrder.setTotalPrice(price * formOrder.getTicketNum());

        req.setAttribute("formOrder", formOrder);

        req.setAttribute("stationSize", list.size());

        req.setAttribute("pathList", list);

        return "f:/jsps/order/order.jsp";
    }

    private double calulatePriceByList(LinkedHashSet<Station> list) {

        DecimalFormat format = new DecimalFormat("#.00");

        double price = 2;

        if (list.size() > 4) {

            int extra = 0;

            if ((list.size() - 4) / 3 > 0){
                extra += list.size() / 3;
            }

            if ((list.size() - 4) % 3 != 0) {
                extra ++;
            }

            price += extra;

        }

        return Double.parseDouble(format.format(price));
    }

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

    /**
     * 跳转orderlist
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String showOrderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1. 得到当前页，默认：1
         * 2. 得到url
         * 3. 从当前session中获取User
         * 4. 使用currPageNum和uid查数据，形成pageBeanList
         * 5. pageBean设置url
         */
        int currPageNum = getCurrPageNum(req);

        int status = getStatus(req);

        if (status < 0 || status > 4) {
            System.out.println("error status.");
            return "f:/jsps/main.jsp";
        }

        String url = getUrl(req);

        User user = (User)req.getSession().getAttribute("sessionUser");

        PageBean<Order> pageBean = this.orderService.showOrderList(user.getUid(), currPageNum, status);

        if (currPageNum > pageBean.getTotalPageNum()) {
            pageBean.setCurrPageNum(1);
        }

        System.out.println("totalPageNum: " + pageBean.getTotalPageNum());

        pageBean.setUrl(url);

        req.setAttribute("status", status);

        req.setAttribute("pageBean", pageBean);

        return "f:/jsps/order/orderlist.jsp";
    }

    /**
     * 获得当前页码
     * @param req
     * @return
     */
    private int getCurrPageNum(HttpServletRequest req) {

        int currPageNum = 1;

        String parameter = req.getParameter("currPageNum");

        if (parameter != null && !parameter.trim().isEmpty()) {

            try {
                currPageNum = Integer.parseInt(parameter);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

        }

        return currPageNum;
    }

    /**
     * 获取订单状态
     * @param req
     * @return
     */
    private int getStatus(HttpServletRequest req) {

        int status = 0;

        String parameter = req.getParameter("status");

        if (parameter != null && !parameter.trim().isEmpty()) {

            try {
                status = Integer.parseInt(parameter);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

        }

        return status;
    }

    /**
     * 截取url
     * @param req
     * @return
     */
    private String getUrl(HttpServletRequest req) {

        String url = req.getRequestURI() + "?" + req.getQueryString();

        /*存在currPageNum则截取*/
        int index = url.lastIndexOf("&currPageNum=");

        if (index != -1) {
            url = url.substring(0, index);
        }

        return url;
    }


}
