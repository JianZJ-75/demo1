package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/18 16:59
 */
public class Solution_10_18 {
    // TODO
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) { // 必须操作
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }
        return nums[n - 2] != 0 && nums[n - 1] != 0 ? ans : -1;
    }
}