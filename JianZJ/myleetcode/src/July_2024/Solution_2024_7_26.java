package July_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/7/26 15:01
 */
public class Solution_2024_7_26 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}