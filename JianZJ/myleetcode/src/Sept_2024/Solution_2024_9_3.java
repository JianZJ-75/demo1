package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/3 20:54
 */
public class Solution_2024_9_3 {
    public long maxStrength(int[] nums) {
        long mx = nums[0], mn = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long x = nums[i];
            long tmp = mn;
            mn = Math.min(Math.min(mn, x), Math.min(mx * x, mn * x));
            mx = Math.max(Math.max(mx, x), Math.max(mx * x, tmp * x));
        }
        return mx;
    }
}