package Stream.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author JianZJ
 * @Date 2024/3/21 0:38
 */
public class Test1 {
    /*
    * 数据过滤
    *
    * 定义一个集合，并添加一些整数1，2，3，4，5，6，7，8，9，10
    * 过滤奇数，只留下偶数
    * 并将结果保存起来*/
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list = list.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(list);
    }
}
