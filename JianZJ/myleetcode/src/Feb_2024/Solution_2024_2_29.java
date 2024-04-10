package Feb_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 16:38
 */
public class Solution_2024_2_29 {
    int res;
    List<Integer>[] edge;
    Set<Long> set = new HashSet<>();
    int n, k, cnt;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        n = edges.length + 1;
        edge = new ArrayList[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges) {
            int u = i[0], v = i[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        for (var i : guesses) {
            set.add((long) i[0] << 32 | i[1]);
        }
        dfs(0, -1);
        calc(0, -1, cnt);
        return res;
    }

    public void dfs(int x, int fa) {
        for (var i : edge[x]) {
            if (i != fa) {
                if (set.contains((long) x << 32 | i)) {
                    cnt++;
                }
                dfs(i, x);
            }
        }
    }

    public void calc(int x, int fa, int ans) {
        if (ans >= k)
            res++;
        for (var i : edge[x]) {
            if (i != fa) {
                cnt = ans;
                if (set.contains((long) x << 32 | i))
                    cnt--;
                if (set.contains((long) i << 32 | x))
                    cnt++;
                calc(i, x, cnt);
            }
        }
    }
}
