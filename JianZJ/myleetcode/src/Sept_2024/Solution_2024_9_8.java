package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/8 20:36
 */
public class Solution_2024_9_8 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = n - 1;
        int l = 0, r = n - 1;
        while (l <= r)
        {
            if (nums[l] * nums[l] >= nums[r] * nums[r]) {
                res[idx--] = nums[l] * nums[l];
                l++;
            } else {
                res[idx--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}