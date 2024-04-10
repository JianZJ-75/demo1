package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/5 14:04
 */
public class Solution_2024_4_5 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mx, int mi) {
        if (root == null)
            return 0;
        mx = Math.max(mx, root.val);
        mi = Math.min(mi, root.val);
        return Math.max(mx - mi, Math.max(dfs(root.left, mx, mi), dfs(root.right, mx, mi)));
    }
}
