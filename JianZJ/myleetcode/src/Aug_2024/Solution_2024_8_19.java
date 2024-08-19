package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/19 23:19
 */
public class Solution_2024_8_19 {
    // TODO
    private static final int MOD = 1_000_000_007;
    private static final int MX = 100_001;
    private static final int[][][] memo = new int[MX][2][3];

    public int checkRecord(int n) {
        return dfs(n, 0, 0);
    }

    private static int dfs(int i, int j, int k) {
        if (i == 0) {
            return 1;
        }
        if (memo[i][j][k] > 0) { // 之前计算过
            return memo[i][j][k];
        }
        long res = dfs(i - 1, j, 0); // 填 P
        if (j == 0) {
            res += dfs(i - 1, 1, 0); // 填 A
        }
        if (k < 2) {
            res += dfs(i - 1, j, k + 1); // 填 L
        }
        return memo[i][j][k] = (int) (res % MOD);
    }
}