package Aug_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/8/7 17:08
 */
public class Solution_2024_8_7 {
    private static int[][][] memo;
    private static int limit;
    private static final int MOD = 1000000007;

    private int dfs(int i, int j, int k) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0)
            return k == 0 && j <= limit ? 1 : 0;
        if (j == 0)
            return k == 1 && i <= limit ? 1 : 0;
        if (memo[i][j][k] != -1)
            return memo[i][j][k];
        if (k == 1)
            memo[i][j][k] = (int) (((long) dfs(i - 1, j, 1) + dfs(i - 1, j, 0) + MOD - dfs(i - limit - 1, j, 0)) % MOD);
        else
            memo[i][j][k] = (int) (((long) dfs(i, j - 1, 1) + dfs(i, j - 1, 0) + MOD - dfs(i, j - limit - 1, 1)) % MOD);
        return memo[i][j][k];
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new int[one + 1][zero + 1][2];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        this.limit = limit;
        return (dfs(one, zero, 1) + dfs(one, zero, 0)) % MOD;
    }
}