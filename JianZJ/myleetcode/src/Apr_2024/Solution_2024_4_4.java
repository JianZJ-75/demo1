package Apr_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/4 18:40
 */
public class Solution_2024_4_4 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] edge = new List[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges)
            edge[i[1]].add(i[0]);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] ok = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ok, false);
            dfs(i, -1, ok, edge);
            ok[i] = false;
            ans.add(new ArrayList<>());
            for (int j = 0; j < n; j++)
                if (ok[j])
                    ans.get(ans.size() - 1).add(j);
        }
        return ans;
    }

    public void dfs(int x, int fa, boolean[] ok, List<Integer>[] edge) {
        ok[x] = true;
        for (var i : edge[x]) {
            if (!ok[i])
                dfs(i, x, ok, edge);
        }
    }
}
