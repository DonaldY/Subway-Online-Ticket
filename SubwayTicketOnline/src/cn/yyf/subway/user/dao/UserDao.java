package cn.yyf.subway.user.dao;

import cn.itcast.jdbc.TxQueryRunner;
import cn.yyf.subway.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * Created by Donald on 2016/8/16.
 */
public class UserDao {
    private QueryRunner qr = new TxQueryRunner();
    /**
     * 按用户名密码查找
     */
    public User findByNameAndPwd(String username, String userpasswd) throws SQLException {
        String sql = "select * from s_user where username=? and userpasswd=?";
        return qr.query(sql, new BeanHandler<User>(User.class), username, userpasswd);
    }

    /**
     * 添加用户
     */
    public void add(User user) throws SQLException{
        String sql = "insert into s_user values(?,?,?,?,?,?)";
        Object[] params = {user.getUid(), user.getUsername(), user.getUserpasswd(), user.getEmail(), user.isStatus(), user.getActivationCode()};
        qr.update(sql, params);
    }

    /**
	 * 校验email是否注册
	 */
    public boolean ajaxValidateEmail(String email) throws SQLException{
        String sql = "select count(1) from s_user where email=?";
        Number number = (Number)qr.query(sql, new ScalarHandler(), email);
        return number.intValue() == 0;
    }

    /**
     * 通过激活码查询用户
     */
    public User findByCode(String code) throws SQLException{
        String sql = "select * from s_user where activationCode =?";
        return qr.query(sql, new BeanHandler<User>(User.class), code);
    }

    /**
     * 更新激活状态
     */
    public void updateStatus(String uid, boolean status) throws SQLException{
        String sql = "update s_user set status=? where uid=?";
        qr.update(sql, status, uid);
    }
}
