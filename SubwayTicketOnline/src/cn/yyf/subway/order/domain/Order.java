package cn.yyf.subway.order.domain;


/**
 * Created by DonaldY on 2017/5/4.
 */
public class Order {

    private String oid;
    private String orderTime;
    private String startTime;
    private String endTime;
    private String city;
    private String fromPath;
    private String toPath;
    private String fromStation;
    private String toStation;
    private String image_w;
    private String image_b;
    private int status;
    private String serialNum;
    private int ticketNum;
    private double price;
    private double totalPrice;
    private String uid;


    public Order() {

    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFromPath() {
        return fromPath;
    }

    public void setFromPath(String fromPath) {
        this.fromPath = fromPath;
    }

    public String getToPath() {
        return toPath;
    }

    public void setToPath(String toPath) {
        this.toPath = toPath;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getImage_w() {
        return image_w;
    }

    public void setImage_w(String image_w) {
        this.image_w = image_w;
    }

    public String getImage_b() {
        return image_b;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Order{" +
            "oid='" + oid + '\'' +
            ", orderTime='" + orderTime + '\'' +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", city='" + city + '\'' +
            ", fromPath='" + fromPath + '\'' +
            ", toPath='" + toPath + '\'' +
            ", fromStation='" + fromStation + '\'' +
            ", toStation='" + toStation + '\'' +
            ", image_w='" + image_w + '\'' +
            ", image_b='" + image_b + '\'' +
            ", status=" + status +
            ", serialNum='" + serialNum + '\'' +
            ", ticketNum=" + ticketNum +
            ", totalPrice=" + totalPrice +
            ", uid='" + uid + '\'' +
            '}';
    }
}
