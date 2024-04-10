package Feb_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 22798
 * @Date 2024/2/9 16:35
 */
public class Solution_2024_2_9 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Map<TreeNode, Integer> dep = new HashMap<>();
    Map<TreeNode, TreeNode> fa = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dep.put(root, 0);
        dfs(root);
        if (dep.get(p) > dep.get(q)) {
            TreeNode t = q;
            q = p;
            p = t;
        }
        while (dep.get(q) != dep.get(p)) {
            q = fa.get(q);
        }
        while (p != q) {
            p = fa.get(p);
            q = fa.get(q);
        }
        return p;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            fa.put(root.left, root);
            dep.put(root.left, dep.get(root) + 1);
            dfs(root.left);
        }
        if (root.right != null) {
            fa.put(root.right, root);
            dep.put(root.right, dep.get(root) + 1);
            dfs(root.right);
        }
    }
}
