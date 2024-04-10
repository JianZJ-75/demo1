package Feb_2024;

import java.util.*;

/**
 * @Author 22798
 * @Date 2024/2/23 20:14
 */
public class Solution_2024_2_23 {
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();
        List<TreeNode> a = new ArrayList<>();
        a.add(root);
        while (!a.isEmpty()) {
            List<TreeNode> t = a;
            a = new ArrayList<>();
            long sum = 0;
            for (TreeNode i : t) {
                sum += i.val;
                if (i.left != null)
                    a.add(i.left);
                if (i.right != null)
                    a.add(i.right);
            }
            res.add(sum);
        }
        Collections.sort(res);
        if (k > res.size())
            return -1;
        return res.get(res.size() - k);
    }
}
