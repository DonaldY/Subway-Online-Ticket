package cn.yyf.subway.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.yyf.subway.category.domain.Category;
import cn.yyf.subway.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Donald on 2016/8/20.
 */

public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryService();

    /**
     * 查找所有子类
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findParent(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        List<Category> parent = categoryService.findParent();
        String json = toJson(parent);
        resp.getWriter().print(json);
        return null;
    }

    public String ajaxFindChildren(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException{
		/*
		 * 1.获取pid
		 * 2.通过pid查询出所有2级分类
		 * 3.把List<Category>转换成json，输出给客户端
		 */
        String pid = req.getParameter("pid");
        List<Category> children = categoryService.findChildrenById(pid);
        String json = toJson(children);
        resp.getWriter().print(json);
        return null;
    }

    public String ajaxFindParentByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException{
        String cname = req.getParameter("cname");
        System.out.println(cname);
        List<Category> parent = categoryService.findParentByName(cname);
        String json = toJson(parent);
        System.out.println(json);
        resp.getWriter().print(json);
        return null;
    }

    //{"cid":"sadf", "cname":"sdfsd"}
    private String toJson(Category category){
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"cid\"").append(":").append("\"").append(category.getCid()).append("\"");
        sb.append(",");
        sb.append("\"cname\"").append(":").append("\"").append(category.getCname()).append("\"");
        sb.append("}");
        return sb.toString();
    }

    //[{"cid":"sadf", "cname":"sdfsd"},{"cid":"sadf", "cname":"sdfsd"}]
    private String toJson(List<Category> categoryList){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < categoryList.size(); ++i){
            sb.append(toJson(categoryList.get(i)));
            if(i < categoryList.size() - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
