package leetcode.Mar_2024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author JianZJ
 * @Date 2024/3/30 23:09
 */
public class Solution_2024_3_30 {
    public int minimumAddedCoins(int[] coins, int target) {
        long l = 0, r = 0;
        Arrays.sort(coins);
        long ans = 0;
        for (var i : coins) {
            while (l + i > r + 1) {
                r += r + 1;
                ans++;
            }
            r += i;
        }
        while (target > r) {
            r += r + 1;
            ans++;
        }
        return (int) ans;
    }
}