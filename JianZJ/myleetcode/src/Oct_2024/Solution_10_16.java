package Oct_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/10/16 22:19
 */
public class Solution_10_16 {
    // TODO
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.min(ans, nums[i] + nums[n - 1 - i]);
        }
        return ans / 2.0;
    }
}