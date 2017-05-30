package cn.yyf.tools.station;
/**
 * Created by DonaldY on 2017/5/19.
 */
public class Station {

    private String name;

    public Station prev;

    public Station next;

    /**
     * 0: 普通站点, 1: 中转站, 2: 转乘公交
     * 3: 转乘火车，4: 转乘飞机
     */
    private int status;

    public Station (String name){
        this.name = name;
    }

   /* public Station (String name, int status) {
        this.name = name;
        this.status = status;
    }*/

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        } else if(o instanceof Station){
            Station s = (Station) o;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}