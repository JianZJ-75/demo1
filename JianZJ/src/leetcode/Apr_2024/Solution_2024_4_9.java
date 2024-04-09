package leetcode.Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/9 14:44
 */
public class Solution_2024_4_9 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = -1, r = n;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] < 0)
                l = mid;
            else
                r = mid;
        }
        int neg = l + 1;
        l = -1;
        r = n;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] > 0)
                r = mid;
            else
                l = mid;
        }
        return Math.max(neg, n - r);
    }
}
