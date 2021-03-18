//package com.java.basic.collection;
//
///**
// * @author admin
// * @date 2021/3/16
// * @description setTest
// */
//
//import top.bgyx.boot.basic.entity.Student;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeSet;
///*
// *description: Set测试* @author: mqxu
// * @create: 2021-03-10**/
//public class SetTest {
//    public static void main(String[] args) {
//        System.out.println("TreeSet示例");
//        Student s1 = Student.builder().name("aaa").age(20).build();
//        Student s2 = Student.builder().name("baa").age(19).build();
//        Student s3 = Student.builder().name("cca").age(22).build();
//        Set<Student> stuSet = new HashSet<>();
//        stuSet.add(s1);
//        stuSet.add(s2);
//        stuSet.add(s3);
//        System.out.println(stuSet);
//        Set<String> set = new TreeSet<>();
//        set.add("C");
//        set.add("A");
//        set.add("B");
//        System.out.println(set);
//        System.out.println("HashSet示例");
//        Set<String> hashSet = new HashSet<> ();
//        hashSet.add("C");
//        hashSet.add("A");
//        hashSet.add("B");//使用for循环遍历
//        System.out.println("使用for循环遍历");
//        Object[] array = hashSet.toArray();
//        for (Object o : array) {
//            System.out.print(o.toString() + " \t");
//        }
////使用iterator遍历
//        System.out.println(" \n\n使用iterator遍历");
//        Iterator<String> iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " \t");
//        }
////使用lambda遍历
//        System.out.println(" \n\n使用lambda遍历");
//        hashSet.forEach(s -> System.out.print(s + " \t"));
////使用方法引用遍历
//        System.out.println(" \n \n使用方法引用遍历");
//        hashSet.forEach(System.out ::println );
//    }
//}