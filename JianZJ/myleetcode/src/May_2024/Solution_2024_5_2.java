package May_2024;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/5/2 16:58
 */
public class Solution_2024_5_2 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] id = new Integer[n];
        Arrays.setAll(id, i -> i);
        // 根据r值排序
        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);

        // 最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[id[i]]);
            sum += quality[id[i]];
        }

        // 从第k个人的r值开始遍历
        double ans = sum * ((double) wage[id[k - 1]] / quality[id[k - 1]]);

        for (int i = k; i < n; i++) {
            int q = quality[id[i]];
            if (q < pq.peek()) {
                sum -= pq.poll() - q;
                pq.offer(q);
                ans = Math.min(ans, sum * ((double) wage[id[i]] / quality[id[i]]));
            }
        }

        return ans;
    }
}
