package leetcode.Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/27 21:27
 */
public class Solution_2024_3_27 {
    // 合并区间
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int ans = 1;
        int maxR = -1;
        for (var i : ranges) {
            if (i[0] > maxR)
                ans = ans * 2 % 1_000_000_007;
            maxR = Math.max(maxR, i[1]);
        }
        return ans;
    }
}
