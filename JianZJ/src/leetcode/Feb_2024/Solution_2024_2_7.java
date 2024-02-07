package leetcode.Feb_2024;

import java.security.KeyPair;
import java.util.*;

/**
 * @Author 22798
 * @Date 2024/2/7 18:43
 */
public class Solution_2024_2_7 {
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
    Map<TreeNode, Integer> dep = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(root, 0);
        root.val = 0;
        bfs(root);
        return root;
    }

    public void bfs(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int sum = 0;
            TreeNode now = dq.peekFirst();
            if (now.left == null && now.right == null)
            {
                dq.pollFirst();
                continue;
            }
            if (now.left != null) {
                sum += now.left.val;
            }
            if (now.right != null) {
                sum += now.right.val;
            }
            sum = mp.get(dep.get(now) + 1) - sum;
            if (now.left != null) {
                now.left.val = sum;
                dq.addLast(now.left);
            }
            if (now.right != null) {
                now.right.val = sum;
                dq.addLast(now.right);
            }
            dq.pollFirst();
        }
    }

    public void dfs(TreeNode root, int depth) {
        dep.put(root, depth);
        mp.put(depth, mp.getOrDefault(depth, 0) + root.val);
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}