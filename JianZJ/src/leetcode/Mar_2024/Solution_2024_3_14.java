package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/14 23:02
 */
public class Solution_2024_3_14 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long res = nums[n - 1];
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] > res)
                res = nums[i - 1];
            else
                res += nums[i - 1];
        }
        return res;
    }
}
