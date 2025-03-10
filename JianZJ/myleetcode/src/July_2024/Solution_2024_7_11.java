package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/11 0:33
 */
public class Solution_2024_7_11 {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i + 1 < n && nums[i + 1] > nums[i]) {
            i++;
        }
        if (i == n - 1)
            return (n + 1l) * n / 2;
        long ans = i + 2;
        for (int j = n - 1; j == n - 1 || nums[j] < nums[j + 1]; j--) {
            while (i >= 0 && nums[i] >= nums[j])
                i--;
            ans += i + 2;
        }
        return ans;
    }
}