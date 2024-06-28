package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/28 19:52
 */
public class Solution_2024_6_28 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 防止加法溢出
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i];
            int t = time[i] + 1; // 注意这里加一了
            for (int j = n; j > 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
            }
        }
        return f[n];
    }
}