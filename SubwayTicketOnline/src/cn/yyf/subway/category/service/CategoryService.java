package cn.yyf.subway.category.service;

import cn.yyf.subway.category.dao.CategoryDao;
import cn.yyf.subway.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Donald on 2016/8/20.
 */
public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> findParent(){
        try {
            return categoryDao.findParent();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Category> findParentByName(String cname){
        try {
            return categoryDao.findParentByName(cname);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Category> findChildrenById(String pid){
        try {
            return categoryDao.findChildrenById(pid);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
