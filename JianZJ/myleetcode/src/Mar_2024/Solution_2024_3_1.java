package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/1 22:09
 */
public class Solution_2024_3_1 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            if (f[i - 1] && nums[i] == nums[i - 1] ||
                    i > 1 && f[i - 2] && nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                            i > 1 && f[i - 2] && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)
                f[i + 1] = true;
        }
        return f[n];
    }
}