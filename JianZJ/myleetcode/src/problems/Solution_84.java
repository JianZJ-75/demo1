package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/3/19 21:50
 */

public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && heights[i] <= heights[dq.peekFirst()]) {
                dq.pollFirst();
            }
            left[i] = dq.isEmpty() ? -1 : dq.peekFirst();
            dq.addFirst(i);
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && heights[i] <= heights[dq.peekFirst()]) {
                dq.pollFirst();
            }
            right[i] = dq.isEmpty() ? n : dq.peekFirst();
            dq.addFirst(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        return res;
    }
}
