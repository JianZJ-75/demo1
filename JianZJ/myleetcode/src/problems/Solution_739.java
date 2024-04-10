package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/3/19 20:50
 */

public class Solution_739 {
    // 解法一 从右到左
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && temperatures[dq.peekFirst()] <= temperatures[i])
                dq.pollFirst();
            if (!dq.isEmpty())
                res[i] = dq.peekFirst() - i;
            dq.addFirst(i);
        }
        return res;
    }

    // 解法二 从左到右
    public int[] dailyTemperatures2(int[] temperatures) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && temperatures[i] > temperatures[dq.peekFirst()]) {
                int j = dq.pollFirst();
                res[j] = i - j;
            }
            dq.addFirst(i);
        }
        return res;
    }
}
