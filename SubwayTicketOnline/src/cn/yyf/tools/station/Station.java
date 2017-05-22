package cn.yyf.tools.station;
/**
 * Created by DonaldY on 2017/5/19.
 */
public class Station {

    private String name;

    public Station prev;

    public Station next;

    public Station (String name){
        this.name = name;
    }

    public String getName() {
        return name;
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