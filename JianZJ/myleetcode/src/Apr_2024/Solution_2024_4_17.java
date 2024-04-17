package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/17 14:35
 */
public class Solution_2024_4_17 {

    private int nowSize, id;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] pos = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int[] cnt = new int[n];
        int mi = Integer.MAX_VALUE;
        int maxSize = 0;
        int ans = -1;
        for (var i : initial) {
            isInitial[i] = true;
            mi = Math.min(mi, i);
        }
        for (int i = 0; i < n; i++) {
            if (pos[i] || isInitial[i]) {
                continue;
            }
            id = -1;
            nowSize = 0;
            dfs(i, graph, isInitial, pos);
            if (id >= 0)
                cnt[id] += nowSize;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[i] > maxSize) {
                maxSize = cnt[i];
                ans = i;
            }
        }
        return ans == -1 ? mi : ans;
    }

    private void dfs(int x, int[][] graph, boolean[] isInitial, boolean[] pos) {
        pos[x] = true;
        nowSize++;
        for (int i = 0; i < graph[x].length; i++) {
            if (graph[x][i] == 0) {
                continue;
            }
            if (isInitial[i]) {
                if (id != -2 && i != id) {
                    id = id == -1 ? i : -2;
                }
            } else if (!pos[i]) {
                dfs(i, graph, isInitial, pos);
            }
        }
    }

}
