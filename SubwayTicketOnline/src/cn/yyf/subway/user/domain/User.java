package cn.yyf.subway.user.domain;

/**
 * Created by Donald on 2016/8/16.
 */
public class User {
    private String uid;
    private String username;
    private String userpasswd;
    private String reuserpasswd;//注册表单
    private String email;
    private String verifyCode;	//验证码
    private boolean status; //1位激活
    private String activationCode; // 激活码

    public User() {
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpasswd() {
        return userpasswd;
    }

    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getReuserpasswd() {
        return reuserpasswd;
    }

    public void setReuserpasswd(String reuserpasswd) {
        this.reuserpasswd = reuserpasswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", userpasswd='" + userpasswd + '\'' +
                ", reuserpasswd='" + reuserpasswd + '\'' +
                ", email='" + email + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                '}';
    }
}
