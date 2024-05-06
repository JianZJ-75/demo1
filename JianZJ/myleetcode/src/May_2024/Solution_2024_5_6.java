package May_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/5/6 16:52
 */
public class Solution_2024_5_6 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[2 * n - 1][n + 1][n + 1];
        for (int[][] ints : f) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, Integer.MIN_VALUE);
            }
        }
        for (int t = 1; t < n * 2 - 1; t++) {
            for (int j = Math.max(t - n + 1, 0); j <= Math.min(t, n - 1); j++) {
                if (grid[t - j][j] < 0) continue;
                for (int k = j; k <= Math.min(t, n - 1); k++) {
                    if (grid[t - k][k] < 0) continue;
                    f[t][j + 1][k + 1] = Math.max(Math.max(f[t - 1][j + 1][k + 1], f[t - 1][j + 1][k]), Math.max(f[t - 1][j][k + 1], f[t - 1][j][k])) +
                            grid[t - j][j] + (k != j ? grid[t - k][k] : 0);
                }
            }
        }
        f[0][1][1] = grid[0][0];
        for (int t = 1; t < 2 * n - 1; t++) {
            for (int j = Math.max(0, t - n + 1); j <= Math.min(t, n - 1); j++) {
                if (grid[t - j][j] < 0)
                    continue;
                for (int k = j; k <= Math.min(t, n - 1); k++) {
                    if (grid[t - k][k] < 0)
                        continue;
                    f[t][j + 1][k + 1] = Math.max(Math.max(f[t - 1][j + 1][k + 1], f[t - 1][j][k + 1]),
                            Math.max(f[t - 1][j + 1][k], f[t - 1][j][k])) + grid[t - j][j] + (j != k ? grid[t - k][k] : 0);
                }
            }
        }
        return Math.max(f[2 * n - 2][n][n], 0);
    }
}
