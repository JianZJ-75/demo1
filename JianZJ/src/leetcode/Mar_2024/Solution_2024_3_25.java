package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/25 22:29
 */
public class Solution_2024_3_25 {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (var i : coins) {
            for (int j = i; j <= amount; j++) {
                f[j] += f[j - i];
            }
        }
        return f[amount];
    }
}
