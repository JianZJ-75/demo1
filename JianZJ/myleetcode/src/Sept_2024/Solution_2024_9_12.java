package Sept_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/9/12 19:58
 */
public class Solution_2024_9_12 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l = -1;
        int r = nums.length / 2 + 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (check(nums, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l * 2;
    }

    private boolean check(int[] nums, int mid) {
        for (int i = 0; i < mid; i++) {
            if (nums[i] * 2 > nums[nums.length - mid + i]) {
                return false;
            }
        }
        return true;
    }

}