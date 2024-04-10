package Feb_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 22798
 * @Date 2024/2/20 18:31
 */
public class Solution_2024_2_20 {
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
    Map<Integer, Integer> mp = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int idx = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = inorder.length;
        for (int i = 0; i < n; i++)
            mp.put(inorder[i], i);
        return dfs(0, n - 1);
    }
    public TreeNode dfs(int l, int r) {
        if (l > r)
            return null;
        int val = preorder[++idx];
        TreeNode left = dfs(l, mp.get(val) - 1);
        TreeNode right = dfs(mp.get(val) + 1, r);
        return new TreeNode(val, left, right);
    }
}
