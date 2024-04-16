package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/16 15:51
 */
public class Solution_2024_4_16 {

    private int nowSize, id;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int mi = Integer.MAX_VALUE;
        int ans = -1;
        int maxSize = 0;
        boolean[] pos = new boolean[n];
        boolean[] isInitial = new boolean[n];
        for (var i : initial) {
            isInitial[i] = true;
            mi = Math.min(mi, i);
        }
        for (var i : initial) {
            if (pos[i]) {
                continue;
            }
            id = -1;
            nowSize = 0;
            dfs(i, graph, isInitial, pos);
            if (nowSize > maxSize && id >= 0 || nowSize == maxSize && id >= 0 && id < ans) {
                ans = id;
                maxSize = nowSize;
            }
        }
        return ans < 0 ? mi : ans;
    }

    private void dfs(int x, int[][] graph, boolean[] isInitial, boolean[] pos) {
        pos[x] = true;
        nowSize++;
        if (id != -2 && isInitial[x]) {
            id = id == -1 ? x : -2;
        }
        for (int i = 0; i < graph[x].length; i++) {
            if (graph[x][i] == 1 && !pos[i]) {
                dfs(i, graph, isInitial, pos);
            }
        }
    }

}
