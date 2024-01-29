package leetcode.Jan_2024;

import java.util.Arrays;

/**
 * @Author: JianZJ
 * @Date: 2024/1/18 0:50
 */
public class Solution_2024_1_18 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + beans[i];
        System.out.println(Arrays.toString(beans));
        System.out.println(Arrays.toString(pre));
        long ans = (long)1e10;
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, pre[n] - pre[i] - (long)(n - i) * beans[i] + pre[i]);
        return ans;
    }
}
