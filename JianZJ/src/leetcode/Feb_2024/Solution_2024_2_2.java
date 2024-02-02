package leetcode.Feb_2024;

import java.util.Arrays;

/**
 * @Author: JianZJ
 * @Date: 2024/2/2 20:25
 */
public class Solution_2024_2_2 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> (aliceValues[j] + bobValues[j]) - (aliceValues[i] + bobValues[i]));
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                a += aliceValues[index[i]];
            else
                b += bobValues[index[i]];
        }
        if (a - b > 0)
            return 1;
        else if (a == b)
            return 0;
        else
            return -1;
    }
}