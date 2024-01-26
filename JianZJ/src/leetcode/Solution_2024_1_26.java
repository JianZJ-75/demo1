package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JianZJ
 * @Date: 2024/1/26 21:19
 */
public class Solution_2024_1_26 {
    static int[] depth = new int[10000];
    static int n;
    static List<Integer>[] edges = new ArrayList[10000];
    static int[][] fa = new int[10000][21];
    static int[][] d = new int[10000][10000];
    static int[][] cnt = new int[10000][27];
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        this.n = n;
        init();
        for (int[] i : edges) {
            this.edges[i[0]].add(i[1]);
            this.edges[i[1]].add(i[0]);
            d[i[0]][i[1]] = i[2];
            d[i[1]][i[0]] = i[2];
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
            int m = depth[queries[i][0]] + depth[queries[i][1]] - 2 * depth[u];
            int res = m;
            for (int j = 1; j <= 26; j++)
                res = Math.min(res, m - (cnt[queries[i][0]][j] + cnt[depth[queries[i][1]]][j] - 2 * cnt[u][j]));
            ans[i] = res;
        }
        return ans;
    }
    // 初始化
    public void init() {
        for (int i = 0; i < n; i++) {
            depth[i] = -1;
            edges[i] = new ArrayList<>();
            for (int j = 0; j < 15; j++)
                fa[i][j] = -1;
        }
    }
    public void dfs(int x) {
        for (int i : edges[x]) {
            if (i != fa[x][0]) {
                fa[i][0] = x;
                for (int j = 1; j <= 26; j++)
                    cnt[i][j] = cnt[fa[i][0]][j];
                cnt[i][d[i][fa[i][0]]]++;
                depth[i] = depth[fa[i][0]] + 1;
                dfs(i);
            }
        }
    }
    public void solve() {
        for (int i = 1; i <= 20; i++)
            for (int j = 0; j < n; j++)
                fa[j][i] = fa[fa[j][i - 1]][i - 1];
    }

    public static void main(String[] args) {
        Solution_2024_1_26 s = new Solution_2024_1_26();
        int[][] a = new int[][]{{0,1,1},{1,2,1},{2,3,1},{3,4,2},{4,5,2},{5,6,2}};
        int[][] b = new int[][]{{0,3},{3,6},{2,6},{0,6}};
        System.out.println(s.minOperationsQueries(7, a, b));
    }
}
