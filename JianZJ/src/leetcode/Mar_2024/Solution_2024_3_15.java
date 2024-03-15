package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/15 15:47
 */
public class Solution_2024_3_15 {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] f = new long[m + 1][n + 1];
        for (var i : prices) {
            f[i[0]][i[1]] = i[2];
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i / 2; k++)
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                for (int k = 1; k <= j / 2; k++)
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
            }
        return f[m][n];
    }
}
