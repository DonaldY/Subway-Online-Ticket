package cn.yyf.subway.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.user.domain.User;
import cn.yyf.subway.user.service.UserService;
import cn.yyf.subway.user.service.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donald on 2016/8/16.
 */

public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    /**
     * 登录
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        //封装表单
        User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);


        //校验表单数据
        String msg = validateLogin(formUser, req.getSession());
        if(msg != "" && msg.length() != 0){
            req.setAttribute("msg", msg);
            req.setAttribute("user", formUser);
            return "f:/jsps/user/login.jsp";
        }

        User user = userService.login(formUser);

        if(user == null){
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("user", formUser);
            return "f:/jsps/user/login.jsp";
        }else {
            //用户状态时否激活
            if(!user.isStatus()){
                req.setAttribute("msg", "用户未激活!");
                req.setAttribute("user", formUser);
                return "f:/jsps/user/login.jsp";
            }else {
                //保存到session
                req.getSession().setAttribute("sessionUser", user);
                //获取用户名保存到cookie中
                String username = user.getUsername();
                username = URLEncoder.encode(username, "utf-8");
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 10);
                resp.addCookie(cookie);
                return "r:/index.jsp";
            }
        }

    }

    /**
     * 登录校验表单
     * @param formUser
     * @param session
     * @return
     */
    private String validateLogin(User formUser, HttpSession session){
        String errors = "";

        //校验登录名
        String username = formUser.getUsername();
        if(username == null || username.trim().isEmpty()){
            errors = "用户名不能为空!";
        }else if(username.length() < 3 || username.length() > 20){
            errors =  "用户名长度必须在3~20之间!";
        }

		//校验登录密码
        String loginpass = formUser.getUserpasswd();
        if(loginpass == null || loginpass.trim().isEmpty()){
            errors =  "密码不能为空!";
        }else if(loginpass.length() < 3 ||loginpass.length() > 20){
            errors = "密码长度必须在3~20之间!";
        }

        /**
         * 后期功能，按输错次数显示验证码
         */
        /*
        String verifyCode = formUser.getVerifyCode();
        String vcode = (String)session.getAttribute("vCode");
        boolean b = verifyCode.equalsIgnoreCase(vcode);
        if(verifyCode == null || verifyCode.trim().isEmpty()){
            errors =  "验证码不能为空!";
        }else if(!b){
            errors =  "验证码错误！";
        }*/

        return errors;
    }

    /**
     * 退出
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String quit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        req.getSession().invalidate();
        return "r:/jsps/user/login.jsp";

    }

    /**
     * 注册
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/**
		 * 封装表单数据到user
		 */
        User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);

        /**
		 * 校验，如果校验失败，保存错误信息，返回到regist.jsp显示
		 */

        Map<String, String> errors = validateRegist(formUser, req.getSession());

        if(errors.size() > 0){
            req.setAttribute("form", formUser);
            req.setAttribute("errors", errors);
            return "f:/jsps/user/regist.jsp";
        }

		/**
		 * 使用service来完成业务
		 */
        this.userService.regist(formUser);
		/**
		 * 保存成功信息,转发到msg.jsp显示
		 */
        String msg = "<p>Welcome to Subway-Ticket-Online! We&#39;ve sent a confirmation email to " + formUser.getEmail() + ".</p>\n" +
                "            <p>Please <b>check your email</b> and click the link to confirm your email address.</p>\n" +
                "            <p>Didn&#39;t receive it? Please double-check the email address you entered, and be sure to look in your spam folder.</p>";
        req.setAttribute("code", "success");
        req.setAttribute("msg", msg);
        return "f:/jsps/msg.jsp";
    }

    /**
     * 校验注册
     * @param formUser
     * @param session
     * @return
     */
    private Map<String, String> validateRegist(User formUser, HttpSession session){
        Map<String, String> errors = new HashMap<String,String>();
        /**
         * Email校验
         */
        String email = formUser.getEmail();
        if(email == null || email.trim().isEmpty()){
            errors.put("email", "Email不能为空!");
        }else if(!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
            errors.put("email", "Email格式不对！");
        }else if(!this.userService.ajaxValidateEmail(email)){
            errors.put("email", "Email已被注册");
        }

		/**
		 * 校验登录密码
		 */
        String userpasswd = formUser.getUserpasswd();
        if(userpasswd == null || userpasswd.trim().isEmpty()){
            errors.put("userpasswd", "密码不能为空!");
        }else if(userpasswd.length() < 3 ||userpasswd.length() > 20){
            errors.put("userpasswd", "密码长度必须在3~20之间!");
        }
		/**
		 * 确认密码校验
		 */
        String reuserpasswd = formUser.getReuserpasswd();
        if(reuserpasswd == null || reuserpasswd.trim().isEmpty()){
            errors.put("reuserpasswd", "确认密码不能为空!");
        }else if(!reuserpasswd.equals(userpasswd)){
            errors.put("reuserpasswd", "密码不一致！");
        }

        return errors;
    }

    /**
     * 校验邮箱
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxValidateEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        boolean b = this.userService.ajaxValidateEmail(email);
        resp.getWriter().print(b);
        return null;
    }

    /**
     * 激活
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String activation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/**
		 * 	1.获取参数激活码
		 * 	2.用激活码调用service方法完成激活
		 *  	service方法有可能抛出异常，把异常信息拿来，保存在request中，转发到msg.jsp显示
		 *  3.	保存成功信息到request转发到msg.jsp显示
		 */
        String code = req.getParameter("activationCode");
        try{
            userService.activation(code);
            req.setAttribute("code", "success");	//通知msg.jsp显示对号
            req.setAttribute("msg", "Activation Success! Please login in immediately!!");
        }catch(UserException e){
            req.setAttribute("msg", e.getMessage());
            req.setAttribute("code", "error");//通知msg.jsp显示x
        }
        return "f:/jsps/msg.jsp";
    }
}
