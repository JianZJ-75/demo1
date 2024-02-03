package leetcode.Feb_2024;

/**
 * @Author 22798
 * @Date 2024/2/3 20:06
 */
public class Solution_2024_2_3 {
    int[][] dp;
    int[] pre;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        pre = new int[n + 1];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        return dfs(0, n - 1);
    }
    public int dfs(int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = pre[j + 1] - pre[i + 1] - dfs(i + 1, j);
        int b = pre[j] - pre[i] - dfs(i, j - 1);
        return dp[i][j] = Math.max(a, b);
    }
}
