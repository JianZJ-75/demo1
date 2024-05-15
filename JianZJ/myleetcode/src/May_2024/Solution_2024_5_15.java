package May_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/5/15 21:02
 */
public class Solution_2024_5_15 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1];
        for (int[] t : tasks) {
            int start = t[0];
            int end = t[1];
            int d = t[2];
            for (int i = start; i <= end; i++) {
                if (run[i]) {
                    d--;
                }
            }
            for (int i = end; d > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
