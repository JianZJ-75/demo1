package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/13 23:28
 */
public class Solution_10_13 {
    // TODO
    private static final int[] memo = new int[1001];

    public int twoEggDrop(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] > 0) { // 之前计算过
            return memo[n];
        }
        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            res = Math.min(res, Math.max(j, twoEggDrop(n - j) + 1));
        }
        return memo[n] = res; // 记忆化
    }
}