package Apr_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/11 21:04
 */
public class Solution_2024_4_11 {

    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    static {
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] edge = new List[n];
        Arrays.setAll(edge, i -> new ArrayList<>());
        for (var i : edges) {
            int u = i[0];
            int v = i[1];
            edge[u].add(v);
            edge[v].add(u);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] dep = new int[MX];
        int[] id = new int[MX];
        dfs(nums, edge, 0, -1, 1, ans, dep, id);
        return ans;
    }

    private void dfs(int[] nums, List<Integer>[] edges, int x, int fa, int depth, int[] ans, int[] dep, int[] id) {
        // 记录当前节点值
        int val = nums[x];
        // 计算当前节点的答案
        int now = 0;
        for (var i : coprime[val]) {
            if (i == 0)
                break;
            if (dep[i] > now) {
                now = dep[i];
                ans[x] = id[i];
            }
        }
        // 记录回溯前数据
        int now_dep = dep[val];
        int now_id = id[val];
        // 更新
        dep[val] = depth;
        id[val] = x;
        // 递归
        for (var i : edges[x]) {
            if (i == fa)
                continue;
            dfs(nums, edges, i, x, depth + 1, ans, dep, id);
        }
        // 回溯
        dep[val] = now_dep;
        id[val] = now_id;
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return b != 0 ? gcd(b, a % b) : a;
    }
}
