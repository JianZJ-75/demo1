package Apr_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/4/8 17:10
 */
public class Solution_2024_4_8 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1])
                nums[idx++] = nums[i];
        }
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < idx; r++) {
            while (nums[r] - n + 1 > nums[l])
                l++;
            ans = Math.min(ans, n - (r - l + 1));
        }
        return ans;
    }
}
