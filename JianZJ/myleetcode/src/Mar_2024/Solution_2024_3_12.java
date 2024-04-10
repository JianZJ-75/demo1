package Mar_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/3/12 17:53
 */
public class Solution_2024_3_12 {
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

    class FindElements {

        Map<Integer, Boolean> mp = new HashMap<>();

        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        public boolean find(int target) {
            return mp.getOrDefault(target, false);
        }

        public void dfs(TreeNode root, int val) {
            if (root == null)
                return;
            root.val = val;
            mp.put(val, true);
            if (root.left != null)
                dfs(root.left, 2 * val + 1);
            if (root.right != null)
                dfs(root.right, 2 * val + 2);
        }
    }

    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
}
