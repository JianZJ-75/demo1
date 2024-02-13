package leetcode.Feb_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/13 18:14
 */
public class Solution_2024_2_13 {
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> data = new ArrayList<>();
        dfs(root, 0, 0, data);
        data.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] != b[0] ? a[0] - b[0] : a[2] - b[2]);
        int last = -100000;
        for (int[] i : data) {
            if (i[1] != last) {
                last = i[1];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(i[2]);
        }
        return ans;
    }

    public void dfs(TreeNode root, int x, int y, List<int[]> data) {
        if (root == null)
            return;
        data.add(new int[]{x, y, root.val});
        dfs(root.left, x + 1, y - 1, data);
        dfs(root.right, x + 1, y + 1, data);
    }
}
