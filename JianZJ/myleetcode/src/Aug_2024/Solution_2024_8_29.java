package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/29 23:32
 */
public class Solution_2024_8_29 {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && grid[i][j] != grid[i + 1][j] || j + 1 < m && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}