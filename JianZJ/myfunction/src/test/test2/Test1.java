package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author JianZJ
 * @Date 2024/6/6 19:43
 */

public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).forEach(System.out::println);

        list.stream().filter(new Test1()::judge).forEach(System.out::println);
    }

    public boolean judge(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}
