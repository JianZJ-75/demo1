package leetcode.Mar_2024;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/3/22 11:39
 */
public class Solution_2024_3_22 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] line = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            row[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            Arrays.setAll(f[i], j -> -1);
        }
        for (int i = 0; i < n; i++)
            line[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        f[0][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j)
                    row[i].poll();
                if (!row[i].isEmpty())
                    f[i][j] = ans(f[i][j], row[i].peek()[0] + 1);
                while (!line[j].isEmpty() && line[j].peek()[1] + grid[line[j].peek()[1]][j] < i)
                    line[j].poll();
                if (!line[j].isEmpty())
                    f[i][j] = ans(f[i][j], line[j].peek()[0] + 1);
                if (f[i][j] != -1) {
                    row[i].offer(new int[]{f[i][j], j});
                    line[j].offer(new int[]{f[i][j], i});
                }
            }
        return f[m - 1][n - 1];
    }

    public int ans(int x, int y) {
        return x == -1 || y < x ? y : x;
    }
}
