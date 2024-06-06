package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author JianZJ
 * @Date 2024/6/6 20:32
 */

public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "aaa", "bbb", "ccc");
        list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);
        list = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list);
    }
}
