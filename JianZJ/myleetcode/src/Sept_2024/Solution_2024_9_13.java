package Sept_2024;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/9/13 21:30
 */
public class Solution_2024_9_13 {
    // TODO
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        int left = 0;
        long sum = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int right = 0; right < chargeTimes.length; right++) {
            // 1. 入
            while (!q.isEmpty() && chargeTimes[right] >= chargeTimes[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(right);
            sum += runningCosts[right];

            // 2. 出
            while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (right - left + 1) * sum > budget) {
                if (q.peekFirst() == left) {
                    q.pollFirst();
                }
                sum -= runningCosts[left++];
            }

            // 3. 更新答案
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}