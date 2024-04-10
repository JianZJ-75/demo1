package Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/26 23:41
 */
public class Solution_2024_3_26 {

//    class Graph {
//
//        public Graph(int n, int[][] edges) {
//
//        }
//
//        public void addEdge(int[] edge) {
//
//        }
//
//        public int shortestPath(int node1, int node2) {
//
//        }
//    }

    class Graph {
        private static final int INF = Integer.MAX_VALUE / 2; // 防止更新最短路时加法溢出

        private final int[][] g;

        public Graph(int n, int[][] edges) {
            g = new int[n][n]; // 邻接矩阵
            for (int[] row : g) {
                Arrays.fill(row, INF);
            }
            for (int[] e : edges) {
                addEdge(e); // 添加一条边（题目保证没有重边）
            }
        }

        public void addEdge(int[] e) {
            g[e[0]][e[1]] = e[2]; // 添加一条边（题目保证这条边之前不存在）
        }

        public int shortestPath(int start, int end) {
            int n = g.length;
            int[] dis = new int[n]; // 从 start 出发，到各个点的最短路，如果不存在则为无穷大
            Arrays.fill(dis, INF);
            dis[start] = 0;
            boolean[] vis = new boolean[n];
            while (true) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && (x < 0 || dis[i] < dis[x])) {
                        x = i;
                    }
                }
                if (x < 0 || dis[x] == INF) {// 所有从 start 能到达的点都被更新了
                    return -1;
                }
                if (x == end) {// 找到终点，提前退出
                    return dis[x];
                }
                vis[x] = true; // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
                for (int y = 0; y < n; y++) {
                    dis[y] = Math.min(dis[y], dis[x] + g[x][y]); // 更新最短路长度
                }
            }
        }
    }

    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */

}
