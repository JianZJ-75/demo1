package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/6 20:14
 */

public class Test3 extends Test2{
    public Test3() {
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        list.stream().filter(super::judge).forEach(System.out::println);
    }
}
