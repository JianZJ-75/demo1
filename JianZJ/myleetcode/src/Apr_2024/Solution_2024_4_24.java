package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/24 20:06
 */
public class Solution_2024_4_24 {
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

    class Solution {
        private int ans = 0;
        public int amountOfTime(TreeNode root, int start) {
            dfs(root, start);
            return ans;
        }

        private int[] dfs(TreeNode root, int start) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left, start);
            int[] right = dfs(root.right, start);
            int lLen = left[0], lF = left[1];
            int rLen = right[0], rF = right[1];
            if (root.val == start) {
                ans = Math.max(lLen, rLen);
                return new int[]{1, 1};
            }
            if (lF == 1 || rF == 1) {
                ans = Math.max(lLen + rLen, ans);
                return new int[]{(lF == 1 ? lLen : rLen) + 1, 1};
            }
            return new int[]{Math.max(lLen, rLen) + 1, 0};
        }
    }
}
