package Feb_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 22798
 * @Date 2024/2/22 21:54
 */
public class Solution_2024_2_22 {
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
    int[] postorder;
    int n;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        n = postorder.length;
        for (int i = 0; i < n; i++)
            mp.put(postorder[i], i);
        return dfs(0, n, 0, n);
    }
    public TreeNode dfs(int prel, int prer, int postl, int postr) {
        if (prel == prer)
            return null;
        if (prel + 1 == prer)
            return new TreeNode(preorder[prel]);
        int len = mp.get(preorder[prel + 1]) - postl + 1;
        TreeNode left = dfs(prel + 1, prel + 1 + len, postl, postl + len);
        TreeNode right = dfs(prel + 1 + len, prer, postl + len, postr - 1);
        return new TreeNode(preorder[prel], left, right);
    }
}