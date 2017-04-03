package cn.yyf.subway.category.dao;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.yyf.subway.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Donald on 2016/8/20.
 */
public class CategoryDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 加载一级分类
     * @return
     * @throws SQLException
     */
    public List<Category> findParent() throws SQLException {
        String sql = "select * from s_category where pid is null order by orderBy";
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
        return toCategoryList(mapList);
    }

    public List<Category> findParentByName(String cname) throws SQLException {
        String sql = "select * from s_category where cname=? and pid is null order by orderBy";
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), cname);
        return toCategoryList(mapList);
    }
    public List<Category> findChildrenById(String pid) throws SQLException {
        String sql = "select * from s_category where pid=? order by orderBy";
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), pid);
        return toCategoryList(mapList);
    }


    /***
     * 把多个map(List<Map>) 映射成多Category(List<Category>)
     * @param mapList
     * @return
     */
    private List<Category> toCategoryList(List<Map<String, Object>> mapList){
        List<Category> categoryList = new ArrayList<Category>();
        for(Map<String, Object> map : mapList){
            Category c = toCategory(map);
            categoryList.add(c);
        }
        return categoryList;
    }

    /**
     * 把一个map中的数据映射到Category中
     * @param map
     * @return
     */
    private Category toCategory(Map<String, Object> map){
		/*
		 * map{cid: xxx, cname:xx, pid:xx, desc:xx, orderBy:xx}
		 * Category{cid:xx,cname:xx, parent:xx, desc:xx}
		 */
        Category category = CommonUtils.toBean(map, Category.class);
        String pid = (String)map.get("pid");	//如果是一级分类，那么pid是null
        if(pid != null){	//如果父分类id不为空
			/*
			 * 使用一个父分类对象来拦截pid
			 * 再把父分类设置给category
			 *
			 */
            Category parent = new Category();
            parent.setCid(pid);
            category.setParent(parent);
        }
        return category;
    }


}
