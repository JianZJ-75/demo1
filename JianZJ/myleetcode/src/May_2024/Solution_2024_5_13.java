package May_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/5/13 14:29
 */
public class Solution_2024_5_13 {
    public int orangesRotting(int[][] grid) {
        int ans = -1;
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        while (!list.isEmpty()) {
            ans++;
            List<int[]> q = list;
            list = new ArrayList<>();
            for (int[] i : q) {
                int x = i[0];
                int y = i[1];
                if (x + 1 < n && grid[x + 1][y] == 1) {
                    list.add(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                    sum--;
                }
                if (y + 1 < m && grid[x][y + 1] == 1) {
                    list.add(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                    sum--;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    list.add(new int[]{x - 1, y});
                    grid[x - 1][y] = 2;
                    sum--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    list.add(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                    sum--;
                }
            }
        }
        return sum > 0 ? -1 : Math.max(0, ans);
    }
}
