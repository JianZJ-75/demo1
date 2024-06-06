package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author JianZJ
 * @Date 2024/6/6 20:18
 */

public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,11", "周芷若,12", "赵敏,13", "张强,63", "张三丰,40");
        List<Student> collect = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(collect);
    }
}
