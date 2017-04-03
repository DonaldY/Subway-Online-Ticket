package cn.yyf.subway.station.domain;

import cn.yyf.subway.category.domain.Category;

/**
 * Created by Donald on 2016/8/24.
 */
public class Station {
    private String sid;
    private String sname;
    private Category parent; //path extends-parent need cid
    private double sitePrice;
    private String desc;
    private int orderBy;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public double getSitePrice() {
        return sitePrice;
    }

    public void setSitePrice(double sitePrice) {
        this.sitePrice = sitePrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "Station{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", parent=" + parent +
                ", sitePrice=" + sitePrice +
                ", desc='" + desc + '\'' +
                ", orderBy=" + orderBy +
                '}';
    }
}
