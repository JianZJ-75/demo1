package leetcode.Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/24 20:32
 */
public class Solution_2024_3_24 {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.setAll(f, i -> Integer.MAX_VALUE / 2);
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (var i : coins) {
            for (int j = i; j <= amount; j++) {
                f[j] = Math.min(f[j], f[j - i] + 1);
            }
        }
        return f[amount] < Integer.MAX_VALUE ? f[amount] : -1;
    }
}
