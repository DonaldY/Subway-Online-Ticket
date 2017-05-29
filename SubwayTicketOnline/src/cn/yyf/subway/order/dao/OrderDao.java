package cn.yyf.subway.order.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yyf.subway.order.domain.Order;
import cn.yyf.subway.pager.Expression;
import cn.yyf.subway.pager.PageBean;
import cn.yyf.subway.pager.PageConstants;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DonaldY on 2017/5/4.
 */
public class OrderDao {
    private QueryRunner qr = new TxQueryRunner();




    /**
     * 按状态查询
     * @param uid
     * @param currPageNum
     * @return
     */
    public PageBean<Order> findOrderByUidAndStatus(String uid, int currPageNum, int status) throws SQLException {

        List<Expression> exprList = new ArrayList<Expression>();

        exprList.add(new Expression("uid", "=", uid));

        if (status != 0) {
            exprList.add(new Expression("status", "=", status + ""));
        }

        return findByCriteria(exprList, currPageNum);

    }

    private PageBean<Order> findByCriteria(List<Expression> exprList, int currPageNum) throws SQLException {

        /**
         * 1. 得到eachPageNum
         * 2. 得到totalRowNum
         * 3. 得到beanList
         * 4. 创建PageBean
         */

        int eachPageNum = PageConstants.ORDER_PAGE_SIZE;

        StringBuilder whereSql = new StringBuilder(" where 1 = 1");

        //对应SQL中？
        List<Object> params = new ArrayList<Object>();

        for (Expression expr : exprList) {

            /**
             * 添加条件
             * 1. and
             * 2. 条件的名称
             * 3. 条件的运算符
             * 4. 如果条件不是is null, 追加 ?
             *      where 1 = 1 and bid = ?
             */

            whereSql.append(" and ").append(expr.getName()).append(" ").append(expr.getOperator())
                .append(" ");

            if(!"is null".equals(expr.getOperator())) {

                whereSql.append("?");

                params.add(expr.getValue());

            }


        }


        String sql = "select count(*) from s_order" + whereSql;
        Number number = (Number)this.qr.query(sql, new ScalarHandler(), params.toArray());
        int totalRowNum = number.intValue();

        sql = "select * from s_order" + whereSql + " order by orderTime desc limit ?,?";
        params.add((currPageNum - 1) * eachPageNum);
        params.add(eachPageNum);

        List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(Order.class), params.toArray());


        PageBean<Order> pageBean = new PageBean<Order>();
        pageBean.setBeanList(beanList);
        pageBean.setCurrPageNum(currPageNum);
        pageBean.setEachPageNum(eachPageNum);
        pageBean.setTotalRowNum(totalRowNum);

        return pageBean;
    }

    /**
     * 按oid加载订单
     * @param oid
     * @return
     * @throws SQLException
     */
    public Order loadOrder(String oid) throws SQLException {

        String sql = "select * from s_order where oid=?";

        Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);

        return order;

    }

    /**
     * 按oid找status
     * @param oid
     * @return
     * @throws SQLException
     */
    public int findStatus(String oid) throws SQLException {

        String sql = "select status from s_order where oid=?";

        Number number = (Number)qr.query(sql, new ScalarHandler(), oid);

        return number.intValue();

    }

    public void updateStatus(String oid, int status) throws SQLException {

        String sql = "update s_order set status=? where oid=?";

        qr.update(sql, status, oid);

    }
}
