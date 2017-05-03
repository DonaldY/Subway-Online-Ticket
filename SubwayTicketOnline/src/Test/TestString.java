package test;

/**
 * Created by Donald on 2016/12/10.
 */
public class TestString {
    public static void main(String[] args) {
        String email = "448641125@qq.com";
        String username = email.substring(0, email.lastIndexOf('@'));
        System.out.println(username);
    }
}
