package July_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/20 14:33
 */
public class Solution_2024_7_20 {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    to.add(new int[]{i, j});
                else if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; k++)
                        from.add(new int[]{i, j});
                }
            }
        }
        int n = to.size();
        int[] f = new int[1 << n];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            int now = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    f[i] = Math.min(f[i], f[i ^ 1 << j] + calc(from.get(j), to.get(now - 1)));
                }
            }
        }
        return f[(1 << n) - 1];
    }

    private int calc(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}