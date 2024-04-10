package Mar_2024;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/3/19 19:15
 */

public class Solution_2024_3_19 {
    // 解法一 单调栈
    public int maximumScore1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] <= nums[dq.peekFirst()]) {
                dq.pollFirst();
            }
            left[i] = dq.isEmpty() ? -1 : dq.peekFirst();
            dq.addFirst(i);
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && nums[i] <= nums[dq.peekFirst()]) {
                dq.pollFirst();
            }
            right[i] = dq.isEmpty() ? n : dq.peekFirst();
            dq.addFirst(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            if (right[i] > k && left[i] < k)
                res = Math.max(res, nums[i] * (right[i] - left[i] - 1));
        return res;
    }

    // 解法二 双指针
    public int maximumScore2(int[] nums, int k) {
        int l = k, r = k;
        int res = nums[k];
        int n = nums.length;
        int h = nums[k];
        while (l != 0 || r != n - 1) {
            if (l == 0 && r < n - 1 || l > 0 && r < n - 1 && nums[r + 1] >= nums[l - 1])
                h = Math.min(h, nums[++r]);
            else if (r == n - 1 && l > 0 || r < n - 1 && l > 0 && nums[l - 1] > nums[r + 1])
                h = Math.min(h, nums[--l]);
            res = Math.max(res, h * (r - l + 1));
        }
        return res;
    }
}
