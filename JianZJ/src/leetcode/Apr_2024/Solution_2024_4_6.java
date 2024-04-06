package leetcode.Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/6 20:14
 */
public class Solution_2024_4_6 {
    class TreeAncestor {

        private int[][] fa;

        public TreeAncestor(int n, int[] parent) {
            fa = new int[n][31];
            for (int i = 0; i < n; i++) {
                fa[i][0] = parent[i];
            }
            for (int i = 1; i < 31; i++) {
                for (int j = 0; j < n; j++) {
                    fa[j][i] = fa[j][i - 1] == -1 ? -1 : fa[fa[j][i - 1]][i - 1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 30; i >= 0; i--) {
                if ((k >> i & 1) == 1) {
                    node = node == -1 ? -1 : fa[node][i];
                }
            }
            return node;
        }
    }

    /**
     * Your TreeAncestor object will be instantiated and called as such:
     * TreeAncestor obj = new TreeAncestor(n, parent);
     * int param_1 = obj.getKthAncestor(node,k);
     */
}
