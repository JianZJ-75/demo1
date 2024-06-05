package test.test4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/6/5 21:23
 */

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(1, 2);
        tmp.put(3, 4);
        tmp.put(5, 6);
        tmp.put(7, 8);
        Set<Map.Entry<Integer, Integer>> entries = tmp.entrySet();
        Map.Entry[] arr1 = new Map.Entry[0];
//        Map.Entry[] arr2 = entries.toArray(arr1);
        arr1 = entries.toArray(arr1);
        Map map = Map.ofEntries(arr1);
        System.out.println(map);
    }
}
