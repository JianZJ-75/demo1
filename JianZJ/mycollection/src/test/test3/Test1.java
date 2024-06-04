package test.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/4 14:46
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 6, 7, 8, 9, 10);
        System.out.println(Collections.binarySearch(list, 3));
    }
}
