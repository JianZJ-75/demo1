package May_2024;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/5/1 17:49
 */
public class Solution_2024_5_1 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        if (n < 2 * candidates + k) {
            long ans = 0;
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }
        int l = candidates;
        int r = n - 1 - candidates;
        long ans = 0;
        while (k-- > 0) {
            if (pre.peek() <= suf.peek()) {
                ans += pre.poll();
                pre.offer(costs[l++]);
            } else {
                ans += suf.poll();
                suf.offer(costs[r--]);
            }
        }
        return ans;
    }
}
