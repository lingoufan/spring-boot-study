package top.bgyx.boot.basic;

/**
 * @author admin
 * @date 2021/3/9
 * @description TestString
 */
public class TestString {
    public static void main(String[] args) {
        String  name  = "111.jpg";
       // int  index = name.length();
        int index = name.lastIndexOf(".");
        System.out.println(index);

        System.out.println(name.substring(index));
    }
}