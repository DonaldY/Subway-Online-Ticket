package cn.yyf.subway.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by DonaldY on 2017/5/25.
 */
public class LoginFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        /**
         * 1.获取session中user
         * 2.判断是否为null
         *  若为null，保存错误信息，转发到msg.jsp
         *  若不为null，ok
         */
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Object user = req.getSession().getAttribute("sessionUser");

        if (user == null) {
            req.setAttribute("code", "error");
            req.setAttribute("msg", "Please login first.");
            req.getRequestDispatcher("/jsps/msg.jsp").forward(req, servletResponse);
        } else {
            filterChain.doFilter(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
