package Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/29 20:52
 */
public class Solution_2024_3_29 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] last = new int[n];
        Arrays.setAll(pre, i -> Integer.MAX_VALUE / 2);
        Arrays.setAll(last, i -> Integer.MAX_VALUE / 2);
        for (int i = 1; i < n - 1; i++)
            pre[i] = Math.min(pre[i - 1], nums[i - 1]);
        for (int i = n - 2; i > 0; i--)
            last[i] = Math.min(last[i + 1], nums[i + 1]);
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 1; i < n - 1; i++)
            if (pre[i] < nums[i] && last[i] < nums[i])
                ans = Math.min(ans, pre[i] + nums[i] + last[i]);
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}
