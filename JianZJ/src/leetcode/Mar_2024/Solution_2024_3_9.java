package leetcode.Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/9 17:42
 */
public class Solution_2024_3_9 {
    long cnt;
    public long kSum(int[] nums, int k) {
        long sum = 0;
        long l = -1, r = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0)
                sum += nums[i];
            else
                nums[i] *= -1;
            r += nums[i];
        }
        Arrays.sort(nums);
        while (r - l > 1) {
            long mid = (l + r) / 2;
            cnt = k - 1;
            dfs(0, mid, nums);
            if (cnt == 0)
                r = mid;
            else
                l = mid;
        }
        return sum - r;
    }

    public void dfs(int i, long sum, int[] nums) {
        if (cnt == 0 || i == nums.length || sum - nums[i] < 0)
            return;
        cnt--;
        dfs(i + 1, sum - nums[i], nums);
        dfs(i + 1, sum, nums);
    }
}
