package Jan_2024;

import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/28 16:43
 */
public class Solution_2024_1_29 {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        List<Integer>[] pos = new ArrayList[27];
        for (int i = 1; i <= 26; i++)
            pos[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = ring.charAt(i) - 'a' + 1;
            pos[idx].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 0x3f3f3f3f);
        for (int i = 0; i < m; i++) {
            int idx = key.charAt(i) - 'a' + 1;
            for (Integer j : pos[idx]) {
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], deal(j, n, 0) + 1);
                    continue;
                }
                int index = key.charAt(i - 1) - 'a' + 1;
                for (Integer k : pos[index])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + deal(j, n, k) + 1);
            }
        }
        Arrays.sort(dp[m - 1]);
        return dp[m - 1][0];
    }
    public int deal(int x, int n, int y) {
        return Math.min((n + x - y) % n, (n + y - x) % n);
    }
}