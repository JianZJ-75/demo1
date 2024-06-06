package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/6 20:11
 */

public class Test2 {

    List<String> list = new ArrayList<>();

    public Test2() {
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        list.stream().filter(this::judge).forEach(System.out::println);
    }

    public boolean judge(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}
