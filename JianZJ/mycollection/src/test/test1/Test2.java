package test.test1;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/5/13 20:33
 */
public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student("zj", 20);
        Student s2 = new Student("hcc", 20);
        Student s3 = new Student("zyd", 20);
        Student s4 = new Student("zj", 20);

        Set<Student> lhs = new LinkedHashSet<>();

        Collections.addAll(lhs, s1, s2, s3, s4);

        System.out.println(lhs);
    }
}
