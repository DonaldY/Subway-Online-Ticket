package cn.yyf.subway.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by DonaldY on 2017/5/28.
 */
public class OrderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**
         * 不能直接访问.jsp
         */
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String url = req.getRequestURI();

        if (url != null && url.endsWith(".jsp")) {

            req.setAttribute("code", "error");
            req.setAttribute("msg", "Error visit.");
            req.getRequestDispatcher("/jsps/msg.jsp").forward(req, servletResponse);

        }

        filterChain.doFilter(req, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
