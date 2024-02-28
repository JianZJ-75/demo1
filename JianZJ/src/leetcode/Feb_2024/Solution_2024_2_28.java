package leetcode.Feb_2024;

import point.Point;

/**
 * @Author 22798
 * @Date 2024/2/28 19:38
 */
public class Solution_2024_2_28 {
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = n / 2; i >= 1; i--) {
            res += Math.abs(cost[2 * i - 1] - cost[2 * i]);
            cost[i - 1] += Math.max(cost[2 * i - 1], cost[2 * i]);
        }
        return res;
    }
}
