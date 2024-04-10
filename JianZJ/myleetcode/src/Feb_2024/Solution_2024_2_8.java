package Feb_2024;

/**
 * @Author 22798
 * @Date 2024/2/8 20:33
 */
public class Solution_2024_2_8 {
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
    class TreeNode {
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
    int x;
    int y;
    int dep_x;
    int dep_y;
    TreeNode tx;
    TreeNode ty;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0);
        if (dep_x == dep_y && tx != ty)
            return true;
        else
            return false;
    }

    public void dfs(TreeNode root, int depth) {
        if (root.left != null) {
            if (root.left.val == x) {
                dep_x = depth + 1;
                tx = root;
            }
            if (root.left.val == y) {
                dep_y = depth + 1;
                ty = root;
            }
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            if (root.right.val == x) {
                dep_x = depth + 1;
                tx = root;
            }
            if (root.right.val == y) {
                dep_y = depth + 1;
                ty = root;
            }
            dfs(root.right, depth + 1);
        }
    }
}
