package May_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/5/4 15:38
 */
public class Solution_2024_5_4 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 捆绑式据
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // 按照结束时间排序
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        // dp
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    private int search(int[][] jobs, int r, int x) {
        int l = -1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (jobs[mid][1] <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
