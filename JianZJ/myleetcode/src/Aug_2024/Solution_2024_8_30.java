package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/30 22:29
 */
public class Solution_2024_8_30 {
    // TODO
    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        int[][] cnt = new int[Integer.toString(nums[0]).length()][10];
        for (int k = 0; k < nums.length; k++) {
            int x = nums[k];
            for (int i = 0; x > 0; x /= 10, i++) {
                ans += k - cnt[i][x % 10]++;
            }
        }
        return ans;
    }
}