package test.test1;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/5 21:40
 */

public class Test1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 5, 7, 8, 3, 56, 12};
        Arrays.sort(arr, Test1::cmp);
    }

    public static int cmp(int a, int b) {
        return a - b;
    }
}
