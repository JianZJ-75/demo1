package leetcode.Jan_2024;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: JianZJ
 * @Date: 2024/1/19 1:03
 */
public class Solution_2024_1_19 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] p = new int[n][2];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            p[i][0] = a;
            p[i][1] = b;
            sum1 += a;
            sum2 += b;
        }
        Arrays.sort(p, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j > 0; j--)
                dp[j] = Math.max(dp[j], dp[j - 1] + p[i][0] + j * p[i][1]);
        for (int i = 0; i <=n ; i++)
            if (sum1 + sum2 * i - dp[i] <= x)
                return i;
        return -1;
    }
}
