package leetcode.Mar_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/3/2 15:37
 */
public class Solution_2024_3_2 {
    Map<Integer, Boolean> mp = new HashMap<>();
    List<Integer>[] edge;
    int res;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        edge = new ArrayList[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges) {
            int u = i[0], v = i[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        for (var i : restricted) {
            mp.put(i, true);
        }
        dfs(0, -1);
        return res;
    }

    public void dfs(int x, int fa) {
        res++;
        for (var i : edge[x]) {
            if (i != fa && !mp.getOrDefault(i, false)) {
                dfs(i, x);
            }
        }
    }
}
