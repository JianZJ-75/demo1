package Apr_2024;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/2 13:45
 */
public class Solution_2024_4_2 {
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

    public static class TreeNode {
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

    static List<TreeNode>[] f = new List[11];

    static {
        Arrays.setAll(f, i -> new ArrayList<>());
        f[1].add(new TreeNode(0));
        for (int i = 2; i < f.length; i++) {
            for (int j = 1; j < i; j++) {
                 for (var l : f[j])
                     for (var r : f[i - j])
                         f[i].add(new TreeNode(0, l, r));
            }
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return f[n % 2 == 0 ? 0 : n / 2 + 1];
    }
}
