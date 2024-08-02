package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/2 21:04
 */
public class Solution_2024_8_2 {
    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int r[] = new int[n], l[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    r[i]++;
                    l[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += (r[i] - 1) * (l[j] - 1);
                }
            }
        }
        return ans;
    }
}