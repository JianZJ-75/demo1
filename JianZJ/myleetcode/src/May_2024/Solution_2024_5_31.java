package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/31 21:24
 */
public class Solution_2024_5_31 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[grid[i][j]]++;
            }
        }
        int[] ans = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (cnt[i] == 2) {
                ans[0] = i;
            } else if (cnt[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
