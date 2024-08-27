package Aug_2024;

import java.util.HashMap;

/**
 * @Author JianZJ
 * @Date 2024/8/27 23:22
 */
public class Solution_2024_8_27 {
    // TODO
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long) n * (n + 1) / 2 + 1) / 2;
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int upper, long k) {
        long cnt = 0;
        int l = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            freq.merge(nums[r], 1, Integer::sum); // 移入右端点
            while (freq.size() > upper) { // 窗口内元素过多
                int out = nums[l++];
                if (freq.merge(out, -1, Integer::sum) == 0) { // 移出左端点
                    freq.remove(out);
                }
            }
            cnt += r - l + 1; // 右端点固定为 r 时，有 r-l+1 个合法左端点
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }
}