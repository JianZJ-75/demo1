package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/13 3:20
 */
public class Solution_2024_7_13 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for (int i = 0; i < n;) {
            int j = i;
            int now = nums[i];
            while (j < n && Integer.bitCount(nums[j]) == Integer.bitCount(nums[i])) {
                if (nums[j] < mx)
                    return false;
                now = Math.max(now, nums[j]);
                j++;
            }
            i = j;
            mx = now;
        }
        return true;
    }
}