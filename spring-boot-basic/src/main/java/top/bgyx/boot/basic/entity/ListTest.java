package top.bgyx.boot.basic.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author admin
 * @date 2021/3/13
 * @description ListTest
 */
public class ListTest {
    public static void main(String[] args) {
        //创建一个List接口的实现类对象，泛型为String，建议带上初始大小
        List<String> list = new ArrayList<>(8);
        //增加三个元素
        list.add("Java");
        list.add("JavaScript");
        list.add("Java");

        System.out.println("用for循环遍历list");
        for (String s : list) {
            System.out.println(s + "\t");
        }
        System.out.println("\n\n用Iterator迭代器遍历list");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println("\n\n用lambda表达式遍历list");
        list.forEach(s -> System.out.print(s + "\t"));

        System.out.println("\n\n使用方法应用用来遍历list，终极简单版本");
        list.forEach(System.out::println
        );
    }
}