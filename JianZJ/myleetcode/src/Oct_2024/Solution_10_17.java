package Oct_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/10/17 18:37
 */
public class Solution_10_17 {
    // TODO
    public int numberOfPermutations(int n, int[][] requirements) {
        int[] req = new int[n];
        Arrays.fill(req, -1);
        req[0] = 0;
        int m = 0;
        for (int[] p : requirements) {
            req[p[0]] = p[1];
            m = Math.max(m, p[1]);
        }
        if (req[0] > 0) {
            return 0;
        }

        int[][] memo = new int[n][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, req[n - 1], req, memo);
    }

    private int dfs(int i, int j, int[] req, int[][] memo) {
        if (i == 0) {
            return 1;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        int r = req[i - 1];
        if (r >= 0) {
            if (j >= r && j - i <= r) {
                res = dfs(i - 1, r, req, memo);
            }
        } else {
            for (int k = 0; k <= Math.min(i, j); k++) {
                res = (res + dfs(i - 1, j - k, req, memo)) % 1_000_000_007;
            }
        }
        return memo[i][j] = res; // 记忆化
    }
}