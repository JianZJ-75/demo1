package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/9 22:38
 */
public class Solution_10_9 {
    // TODO
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k));
            // 如果 x 是 nums[j] 的子集，就退出循环
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}