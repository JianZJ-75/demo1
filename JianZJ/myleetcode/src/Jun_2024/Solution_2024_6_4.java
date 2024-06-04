package Jun_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/4 14:07
 */
public class Solution_2024_6_4 {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        int[] ans = new int[n];
        List<int[]>[] edge = new List[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            int weight = i[2];
            edge[u].add(new int[] {v, weight});
            edge[v].add(new int[] {u, weight});
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int[] e : edge[i]) {
                int cnt = dfs(e[0], i, e[1], signalSpeed, edge);
                ans[i] += sum * cnt;
                sum += cnt;
            }
        }
        return ans;
    }

    private int dfs(int x, int fa, int d, int signalSpeed, List<int[]>[] edge) {
        int cnt = d % signalSpeed == 0 ? 1 : 0;
        for (int[] e : edge[x]) {
            if (e[0] == fa)
                continue;
            cnt += dfs(e[0], x, d + e[1], signalSpeed, edge);
        }
        return cnt;
    }
}
