package Jan_2024;

import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/26 21:19
 */
public class Solution_2024_1_26 {
    static int[] depth = new int[10000];
    static int n;
    static List<Integer>[] edges = new ArrayList[10000];
    static int[][] fa = new int[10000][21];
    static int[][] cnt = new int[10000][27];
    static Map<Integer, Integer>[] mp = new Map[10000];
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            mp[i] = new HashMap<>();
            this.edges[i] = new ArrayList<>();
        }
        for (int[] i : edges) {
            this.edges[i[0]].add(i[1]);
            this.edges[i[1]].add(i[0]);
            mp[i[0]].put(i[1], i[2]);
            mp[i[1]].put(i[0], i[2]);
        }
        depth[0] = 0;
        dfs(0);
        solve();
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (depth[u] < depth[v]) {
                int t = u;
                u = v;
                v = t;
            }
            for (int j = 20; j >= 0; j--)
                if (depth[fa[u][j]] >= depth[v])
                    u = fa[u][j];
            for (int j = 20; j >= 0; j--)
                if (fa[u][j] != fa[v][j]) {
                    u = fa[u][j];
                    v = fa[v][j];
                }
            if (u != v)
                u = fa[u][0];
            int m = depth[queries[i][0]] + depth[queries[i][1]] - 2 * depth[u];
            int res = m;
            for (int j = 1; j <= 26; j++)
                res = Math.min(res, m - (cnt[queries[i][0]][j] + cnt[queries[i][1]][j] - 2 * cnt[u][j]));
            ans[i] = res;
        }
        return ans;
    }
    public void dfs(int x) {
        for (int i : edges[x]) {
            if (i != fa[x][0]) {
                fa[i][0] = x;
                for (int j = 1; j <= 26; j++)
                    cnt[i][j] = cnt[fa[i][0]][j];
                cnt[i][mp[i].get(fa[i][0])]++;
                depth[i] = depth[fa[i][0]] + 1;
                dfs(i);
            }
        }
    }
    // 倍增法
    public void solve() {
        for (int i = 1; i <= 20; i++)
            for (int j = 0; j < n; j++)
                fa[j][i] = fa[fa[j][i - 1]][i - 1];
    }
}