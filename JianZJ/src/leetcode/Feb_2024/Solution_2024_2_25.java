package leetcode.Feb_2024;

/**
 * @Author 22798
 * @Date 2024/2/25 21:00
 */
public class Solution_2024_2_25 {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (res.val > p.val && res.val > q.val)
                res = res.left;
            else if (res.val < p.val && res.val < q.val)
                res = res.right;
            else
                break;
        }
        return res;
    }
}
