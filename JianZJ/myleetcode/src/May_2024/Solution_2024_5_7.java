package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/7 21:47
 */
public class Solution_2024_5_7 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] f = new int[n + 1][m + 2][m + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < Math.min(m, i + 1); j++) {
                for (int k = Math.max(j + 1, m - 1 - i); k < m; k++) {
                    f[i][j + 1][k + 1] = max(
                            f[i + 1][j][k], f[i + 1][j][k + 1], f[i + 1][j][k + 2],
                            f[i + 1][j + 1][k], f[i + 1][j + 1][k + 1], f[i + 1][j + 1][k + 2],
                            f[i + 1][j + 2][k], f[i + 1][j + 2][k + 1], f[i + 1][j + 2][k + 2]
                    ) + grid[i][j] + grid[i][k];
                }
            }
        }
        return f[0][1][m];
    }

    private int max(int x, int... y) {
        for (int i : y) {
            x = Math.max(x, i);
        }
        return x;
    }
}
