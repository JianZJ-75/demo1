package May_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/5/17 15:34
 */
public class Solution_2024_5_17 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = difficulty.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> difficulty[a] - difficulty[b]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int m = worker.length;
        int k = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            while (k < n && difficulty[idx[k]] <= worker[i]) {
                pq.offer(profit[idx[k]]);
                k++;
            }
            if (pq.size() != 0) {
                ans += pq.peek();
            }
        }
        return ans;
    }
}
