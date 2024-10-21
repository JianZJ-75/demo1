package Oct_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/10/21 21:09
 */
public class Solution_10_21 {
    // TODO
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for (int i = 1; i < n; i++) {
            int mx = Math.max(nums[i - 1] + k, nums[n - 1] - k);
            int mn = Math.min(nums[0] + k, nums[i] - k);
            ans = Math.min(ans, mx - mn);
        }
        return ans;
    }
}