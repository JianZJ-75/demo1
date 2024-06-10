package test.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/10 21:02
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "zj,12", "hcc,11", "zyd,1");
        Student[] students = list.stream().map(Student::new).toArray(Student[]::new);
    }
}