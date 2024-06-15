package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/15 23:38
 */
public class Solution_2024_6_15 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int l = 0, r = 0;
        int n = nums.length;
        for (; r < n; r++) {
            while (nums[l] + k < nums[r] - k)
                l++;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}