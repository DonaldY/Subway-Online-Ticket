package cn.yyf.subway.pager;

/**
 * Created by DonaldY on 2017/5/22.
 */
public class Expression {

    private String name;
    private String operator;
    private String value;

    public Expression() {

    }

    public Expression(String name, String operator, String value) {

        this.name = name;
        this.operator = operator;
        this.value = value;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expression [name=" + this.name + ", operator=" + this.operator
            + ", value=" + this.value + "]";
    }
}
