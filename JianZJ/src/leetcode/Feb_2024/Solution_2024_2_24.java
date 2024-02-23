package leetcode.Feb_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/24 1:59
 */
public class Solution_2024_2_24 {
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
    List<Integer> res = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        int[] a = res.stream().mapToInt(i -> i).toArray();
        List<List<Integer>> ans = new ArrayList<>();
        int n = res.size();
        for (Integer i : queries) {
            ans.add(new ArrayList<>());
            int l = -1, r = n;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (a[mid] <= i)
                    l = mid;
                else
                    r = mid;
            }
            if (l < 0)
                ans.get(ans.size() - 1).add(-1);
            else
                ans.get(ans.size() - 1).add(a[l]);
            if (l >= 0 && a[l] == i)
                ans.get(ans.size() - 1).add(a[l]);
            else if (r >= n)
                ans.get(ans.size() - 1).add(-1);
            else
                ans.get(ans.size() - 1).add(a[r]);
        }
        return ans;
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorder(root.left);
        res.add(root.val);
        if (root.right != null)
            inorder(root.right);
    }
}
