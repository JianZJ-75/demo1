package leetcode.Mar_2024;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/3/17 18:38
 */

public class Solution_2024_3_17 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<Integer>[] edge = new List[n];
        int[] d = new int[n];
        List<Integer> res = new ArrayList<>();
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges) {
            int u = i[0], v = i[1];
            edge[u].add(v);
            edge[v].add(u);
            d[u]++;
            d[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 1)
                q.offer(i);
        while (!q.isEmpty()) {
            res.clear();
            for (int i = q.size(); i > 0; i--) {
                int x = q.poll();
                res.add(x);
                for (var j : edge[x]) {
                    if (--d[j] == 1)
                        q.offer(j);
                }
            }
        }
        return res;
    }
}
