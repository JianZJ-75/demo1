package Apr_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/4/27 22:24
 */
public class Solution_2024_4_27 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i] = Math.max(ans[i], calc(grid[j][i]));
            }
        }
        return ans;
    }

    private int calc(int x) {
        if (x == 0) {
            return 1;
        }
        int res = 0;
        if (x < 0) {
            res++;
            x *= -1;
        }
        while (x > 0) {
            res++;
            x /= 10;
        }
        return res;
    }
}
