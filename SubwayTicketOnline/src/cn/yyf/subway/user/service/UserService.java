package cn.yyf.subway.user.service;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.yyf.subway.user.dao.UserDao;
import cn.yyf.subway.user.domain.User;
import cn.yyf.subway.user.service.exception.UserException;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by Donald on 2016/8/16.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user){
        try {
            return userDao.findByNameAndPwd(user.getUsername(), user.getUserpasswd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 注册
     * @param user
     */
    public void regist(User user){
        /**
		 * 数据补齐
		 */
        String email = user.getEmail();
        String username = email.substring(0, email.lastIndexOf('@'));
        user.setUsername(username);
        user.setUid(CommonUtils.uuid());
        user.setStatus(false);
        user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());
        try{
            userDao.add(user);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
		/*
		 * 3.发送邮件
		 */
        Properties prop = new Properties();
        try{
            prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
        }catch(IOException e1){
            throw new RuntimeException(e1);
        }

		/*
		 * 登录邮件服务器
		 */
        String host = prop.getProperty("host"); 	//服务器主机名
        String name = prop.getProperty("username");	//登录名
        String pass = prop.getProperty("password");	//登录密码
        Session session = MailUtils.createSession(host, name, pass);
		/*
		 * 创建mail对象
		 */
        String from = prop.getProperty("from");
        String to = user.getEmail();
        String subject = prop.getProperty("subject");
        //因为里面有占位符，所以要用后面那个参数替换
        //MessageForm.format方法会把第一个参数中的{0}， 使用第二个参数来变换。
        //例如MessageFormat.format("你好{0}"，"你{1}", "张三");
        String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
        Mail mail = new Mail(from, to, subject, content);
		/*
		 * 发送邮件
		 */
        try{
            MailUtils.send(session, mail);
        }catch(MessagingException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 校验邮箱
     * @param email
     * @return
     */
    public boolean ajaxValidateEmail(String email){
        try{
            return userDao.ajaxValidateEmail(email);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
	 * 激活功能
	 */
    public void activation(String code) throws UserException {
		/**
		 * 1.通过激活码查询用户
		 * 2.如果User为null，说明是无效激活码，抛出异常，给出异常信息（无效激活码）
		 * 3.查看用户状态是否为true，如果为true，抛出异常，给出异常信息（请不要二次激活）
		 * 4.修改用户状态为true
		 */
        try{
            User user = userDao.findByCode(code);
            if(user == null)
                throw new UserException("无效的激活码！");
            if(user.isStatus())
                throw new UserException("您已尽激活了，不要二次激活！");
            userDao.updateStatus(user.getUid(), true);	//修改状态
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
