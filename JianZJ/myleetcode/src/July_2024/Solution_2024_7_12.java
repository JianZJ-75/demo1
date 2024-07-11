package July_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/7/12 1:26
 */
public class Solution_2024_7_12 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
             int t = nums[i + 1];
             nums[i + 1] = nums[i];
             nums[i] = t;
        }
        return nums;
    }
}