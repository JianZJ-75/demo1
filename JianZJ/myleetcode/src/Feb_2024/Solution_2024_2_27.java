package Feb_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/27 21:23
 */
public class Solution_2024_2_27 {
    static int N = (int)1e5;
    static boolean[] ok = new boolean[N + 1];
    static {
        ok[1] = true;
        for (int i = 2; i <= N / i; i++) {
            if (!ok[i]) {
                for (int j = i * i; j <= N; j += i)
                    ok[j] = true;
            }
        }
    }
    public long countPaths(int n, int[][] edges) {
        long res = 0;
        List<Integer>[] edge = new ArrayList[n + 1];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for(var i : edges) {
            int u = i[0], v = i[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        int[] len = new int[n + 1];
        List<Integer> node = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (ok[i])
                continue;
            int sum = 0;
            for (var j : edge[i]) {
                if(!ok[j])
                    continue;
                if (len[j] == 0) {
                    node.clear();
                    dfs(j, i, node, edge);
                    for (var k : node) {
                        len[k] = node.size();
                    }
                }
                res += (long) len[j] * sum;
                sum += len[j];
            }
            res += sum;
        }
        return res;
    }
    public void dfs(int x, int fa, List<Integer> node, List<Integer>[] edge) {
        node.add(x);
        for (var i : edge[x]) {
            if (i != fa && ok[i])
                dfs(i, x, node, edge);
        }
    }
}