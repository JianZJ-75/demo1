package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/16 17:18
 */
public class Solution_2024_3_16 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int idx = 0;
        int[][] f = new int[m][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (j - 1 >= 0 && i + 1 < n && grid[j - 1][i + 1] > grid[j][i])
                    f[j][i] = Math.max(f[j][i], f[j - 1][i + 1] + 1);
                if (i + 1 < n && grid[j][i + 1] > grid[j][i])
                    f[j][i] = Math.max(f[j][i], f[j][i + 1] + 1);
                if (j + 1 < m && i + 1 < n && grid[j + 1][i + 1] > grid[j][i])
                    f[j][i] = Math.max(f[j][i], f[j + 1][i + 1] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++)
            res = Math.max(res, f[i][0]);
        return res;
    }
}
