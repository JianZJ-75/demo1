package leetcode;

/**
 * @Author: JianZJ
 * @Date: 2024/1/21 11:46
 */
public class Solution_2024_1_21 {
    int[] nums;
    int k;
    int n;
    public int splitArray(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        this.n = nums.length;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            l = Math.max(nums[i], l);
        }
        l--;
        r++;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (check(mid))
                r = mid;
            else
                l = mid;
        }
        return r;
    }

    public boolean check(int mid) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + nums[i] <= mid)
                sum += nums[i];
            else {
                if (cnt == k)
                    return false;
                cnt++;
                sum = nums[i];
            }
        }
        return true;
    }
}
