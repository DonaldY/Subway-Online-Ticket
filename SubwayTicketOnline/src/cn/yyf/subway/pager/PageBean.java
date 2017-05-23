package cn.yyf.subway.pager;

/**
 * Created by DonaldY on 2017/5/22.
 */

import java.util.List;

/**
 * 分页
 * @param <T>
 */
public class PageBean<T> {

    private int currPageNum;
    private int totalRowNum;
    private int eachPageNum;
    private String url;       //请求路径和参数
    private List<T> beanList;

    /**
     * 总页数
     * @return
     */
    public int getTotalPageNum() {

        int totalPageNum = this.totalRowNum / this.eachPageNum;

        return this.totalRowNum % this.eachPageNum == 0 ? totalPageNum : totalPageNum + 1;

    }

    public int getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(int currPageNum) {
        this.currPageNum = currPageNum;
    }

    public int getTotalRowNum() {
        return totalRowNum;
    }

    public void setTotalRowNum(int totalRowNum) {
        this.totalRowNum = totalRowNum;
    }

    public int getEachPageNum() {
        return eachPageNum;
    }

    public void setEachPageNum(int eachPageNum) {
        this.eachPageNum = eachPageNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
