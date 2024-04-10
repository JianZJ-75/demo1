package Jan_2024;

/**
 * @Author: JianZJ
 * @Date: 2024/1/23 12:08
 */
public class Solution_2024_1_23 {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int res = -1;
        for (int i = 0; i < n - 1;) {
            int j = i + 1;
            int len = 1;
            int t = nums[j] - nums[i];
            if (t != 1) {
                i++;
                continue;
            }
            while (j < n && nums[j] - nums[i] == t) {
                j++;
                i++;
                len++;
                t *= -1;
            }
            res = Math.max(res, len);
            i = j - 1;
        }
        return res;
    }
}
