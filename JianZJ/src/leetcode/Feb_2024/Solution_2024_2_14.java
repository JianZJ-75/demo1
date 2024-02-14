package leetcode.Feb_2024;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/14 21:02
 */
public class Solution_2024_2_14 {
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
        TreeNode() {};
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }
    public void bfs(TreeNode root, List<List<Integer>> ans) {
        int k = 0, cnt = 1, mx = 1;
        if (root == null)
            return;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        while (cnt != 0)
        {
            if (k == 0 && mx == cnt)
                ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(dq.peekFirst().val);
            if (dq.peekFirst().left != null) {
                dq.addLast(dq.peekFirst().left);
                k++;
            }
            if (dq.peekFirst().right != null) {
                dq.addLast(dq.peekFirst().right);
                k++;
            }
            dq.pollFirst();
            cnt--;
            if (cnt == 0)
            {
                cnt = k;
                mx = k;
                k = 0;
            }
        }
    }
}
