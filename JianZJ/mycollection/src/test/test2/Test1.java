package test.test2;

import java.util.TreeMap;

/**
 * @Author JianZJ
 * @Date 2024/6/3 16:40
 */
public class Test1 {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap<>();

        tm.put(new Student("zj", 19), "宣城");
        tm.put(new Student("hcc", 18), "滁州");
        tm.put(new Student("zyd", 19), "池州");

        System.out.println(tm);
    }
}
