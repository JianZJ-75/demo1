package July_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/7/18 0:30
 */
public class Solution_2024_7_18 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int w = p[0];
            int v = p[1];
            if (w > dis[v])
                continue;
            for (int[] tmp : g[v]) {
                int y = tmp[0];
                int now = w + tmp[1];
                if (now < disappear[y] && (dis[y] < 0 || now < dis[y])) {
                    dis[y] = now;
                    pq.add(new int[] {now, y});
                }
            }
        }
        return dis;
    }
}