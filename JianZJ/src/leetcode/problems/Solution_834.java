package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/2/29 16:40
 */
public class Solution_834 {
    List<Integer>[] edge;
    int[] res, size;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        edge = new ArrayList[n];
        res = new int[n];
        size = new int[n];
        this.n = n;
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges) {
            int u = i[0], v = i[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        dfs(0, -1, 0);
        calc(0, -1);
        return res;
    }

    public void dfs(int x, int fa, int depth) {
        res[0] += depth;
        size[x] = 1;
        for (var i : edge[x]) {
            if (i != fa) {
                dfs(i, x, depth + 1);
                size[x] += size[i];
            }
        }
    }

    public void calc(int x, int fa) {
        for (var i : edge[x]) {
            if (i != fa) {
                res[i] = res[x] + n - 2 * size[i];
                calc(i, x);
            }
        }
    }
}
