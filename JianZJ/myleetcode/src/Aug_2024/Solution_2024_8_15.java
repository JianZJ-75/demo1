package Aug_2024;

import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/8/15 21:37
 */
public class Solution_2024_8_15 {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] f = new int[n + 1][m + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int min = Math.min(f[i + 1][j], f[i][j + 1]);
                int now = grid.get(i).get(j);
                ans = Math.max(ans, now - min);
                f[i + 1][j + 1] = Math.min(now, min);
            }
        }
        return ans;
    }
}