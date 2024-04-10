package Mar_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/3/5 14:38
 */
public class Solution_2024_3_5 {
    static final int MOD = (int)1e9 + 7;
    // 邻接矩阵 O(n * n)
    public int countPaths01(int n, int[][] roads) {
        long[][] edge = new long[n][n];
        for (var i : edge) {
            Arrays.setAll(i, e -> (long)1e12);
        }
        for (var i : roads) {
            int u = i[0];
            int v = i[1];
            long val =  i[2];
            edge[u][v] = val;
            edge[v][u] = val;
        }
        long[] dist = new long[n];
        Arrays.setAll(dist, i -> (long)1e12);
        int[] f = new int[n];
        f[0] = 1;
        boolean[] ok = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!ok[i] && (x < 0 || dist[i] < dist[x]))
                    x = i;
            }
            if (x == n - 1)
                return f[n - 1];
            ok[x] = true;
            for (int i = 0; i < n; i++) {
                long val = dist[x] + edge[x][i];
                if (val < dist[i]) {
                    dist[i] = val;
                    f[i] = f[x];
                } else if (val == dist[i]) {
                    f[i] = (f[i] + f[x]) % MOD;
                }
            }
        }
    }

    // 邻接表 O(m * log m) 如果输入的是稠密图，的时间复杂度为 O(n * n * log n)
    public int countPaths02(int n, int[][] roads) {
        List<long[]>[] edge = new ArrayList[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : roads) {
            int u = i[0];
            int v = i[1];
            long val = i[2];
            edge[u].add(new long[]{v, val});
            edge[v].add(new long[]{u, val});
        }
        long[] dist = new long[n];
        Arrays.setAll(dist, i -> (long)1e12);
        int[] f = new int[n];
        f[0] = 1;
        dist[0] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        q.offer(new long[]{dist[0], 0});
        while (true) {
            long[] t = q.poll();
            long dx = t[0];
            int x = (int) t[1];
            if (x == n - 1)
                return f[n - 1];
            if (dx > dist[x])
                continue;
            for (var i : edge[x]) {
                int y = (int) i[0];
                long val = dist[x] + i[1];
                if (val < dist[y]) {
                    dist[y] = val;
                    f[y] = f[x];
                    q.offer(new long[]{dist[y], y});
                } else if (val == dist[y]) {
                    f[y] = (f[y] + f[x]) % MOD;
                }
            }
        }
    }
}
