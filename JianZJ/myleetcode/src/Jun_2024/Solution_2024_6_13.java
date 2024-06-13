package Jun_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/6/13 17:14
 */
public class Solution_2024_6_13 {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        Deque<Integer> q = new ArrayDeque<>();
        long ans = 0;
        long total_profit = 0;
        Set<Integer> pos = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (i < k) {
                total_profit += profit;
                if (!pos.add(category))
                    q.offer(profit);
            } else {
                if (!q.isEmpty() && pos.add(category))
                    total_profit = total_profit - q.pollLast() + profit;
            }
            ans = Math.max(ans, total_profit + (long) pos.size() * pos.size());
        }
        return ans;
    }
}