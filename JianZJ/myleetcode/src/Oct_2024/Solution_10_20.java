package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/20 20:54
 */
public class Solution_10_20 {
    // TODO
    public int smallestRangeI(int[] nums, int k) {
        int mn = nums[0];
        int mx = nums[0];
        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return Math.max(mx - mn - 2 * k, 0);
    }
}