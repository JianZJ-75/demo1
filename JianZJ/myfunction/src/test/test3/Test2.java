package test.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/10 21:06
 */
public class Test2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Collections.addAll(list, new Student("zj", 12), new Student("hcc", 11), new Student("zyd", 1));
        String[] array = list.stream().map(Student::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}