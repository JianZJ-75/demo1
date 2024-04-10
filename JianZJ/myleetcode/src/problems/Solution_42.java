package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/3/19 21:16
 */

public class Solution_42 {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && height[i] >= height[dq.peekFirst()]) {
                int j = dq.pollFirst();
                if (dq.isEmpty())
                    break;
                int h = Math.min(height[dq.peekFirst()], height[i]) - height[j];
                res += h * (i - dq.peekFirst() - 1);
            }
            dq.addFirst(i);
        }
        return res;
    }
}
