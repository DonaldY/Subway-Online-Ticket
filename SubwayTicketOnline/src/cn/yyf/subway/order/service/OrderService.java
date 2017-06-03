package cn.yyf.subway.order.service;

import cn.itcast.jdbc.JdbcUtils;
import cn.yyf.subway.order.dao.OrderDao;
import cn.yyf.subway.order.domain.Order;
import cn.yyf.subway.pager.PageBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by DonaldY on 2017/5/4.
 */
public class OrderService {

    private OrderDao orderDao = new OrderDao();


    public Map<String,List<String>> getMapByCity(String city) {

        return null;

    }

    public PageBean<Order> showOrderList(String uid, int currPageNum, int status) {

        try {

            JdbcUtils.beginTransaction();

            PageBean<Order> pageBean = this.orderDao.findOrderByUidAndStatus(uid, currPageNum, status);

            JdbcUtils.commitTransaction();

            return pageBean;

        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    public Order loadOrder(String oid) {

        try {
            JdbcUtils.beginTransaction();
            Order order = this.orderDao.loadOrder(oid);
            JdbcUtils.commitTransaction();
            return order;
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {}
            throw new RuntimeException(e);
        }
    }

    public int findStatus(String oid) {
        try {
            return this.orderDao.findStatus(oid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(String oid, int status) {
        try {
            this.orderDao.updateStatus(oid, status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createOrder(Order order) {



    }
}
