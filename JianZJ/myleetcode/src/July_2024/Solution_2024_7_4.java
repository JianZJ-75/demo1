package July_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/4 22:09
 */
public class Solution_2024_7_4 {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int max = 0;
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            int j = i;
            int len = 0;
            while (j < n && nums[j] == nums[i]) {
                pos.add(j);
                j++;
                len++;
            }
            max = Math.max(max, len);
            i = j;
        }
        max = Math.min(3, Math.min(max, k));
        if (maxChanges >= k - max) {
            return (k - max) * 2 + Math.max(max - 1, 0);
        }
        int nn = pos.size();
        long[] pre = new long[nn + 1];
        for (int i = 1; i <= nn; i++)
            pre[i] = pre[i - 1] + pos.get(i - 1);
        int size = k - maxChanges;
        long ans = Long.MAX_VALUE;
        for (int r = size; r <= nn; r++) {
            int l = r - size;
            int idx = l + size / 2;
            int tmp = pos.get(idx);
            long s1 = tmp * (idx - l) - (pre[idx] - pre[l]);
            long s2 = pre[r] - pre[idx] - tmp * (r - idx);
            ans = Math.min(ans, s1 + s2);
        }
        return ans + maxChanges * 2;
    }
}