package leetcode.Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/3 18:17
 */
public class Solution_2024_4_3 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode l = getTargetCopy(original.left, cloned.left, target);
        if (l != null)
            return l;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
