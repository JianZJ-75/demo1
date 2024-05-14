package test;

import java.util.Collections;
import java.util.HashSet;

/**
 * @Author JianZJ
 * @Date 2024/5/13 20:21
 */
public class Test1 {
    public static void main(String[] args) {
        /*
        * 需求:
        * 创建一个存储学生对象的集合, 存储多个学生对象
        * 实用程序实现控制台遍历该集合
        * 要求:
        * 学生对象的成员变量值相同, 我们就认为是同一对象
        * */

        // 创建学生对象
        Student s1 = new Student("zj", 20);
        Student s2 = new Student("hcc", 20);
        Student s3 = new Student("zyd", 20);
        Student s4 = new Student("zj", 20);

        // 创建集合
        HashSet<Student> hs = new HashSet<>();

        // 添加元素
        Collections.addAll(hs, s1, s2, s3, s4);

        // 打印集合
        System.out.println(hs);
    }
}
