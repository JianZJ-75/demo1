package Feb_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/19 21:18
 */
public class Solution_2024_2_19 {
    /**
     * Definition for a Node.
     * public class Node {
     *     int val;
     *     ListM<Node> children;
     *     Node() {}
     *     Node(int _val) {
     *          val = _val;
     *     }
     *     Node(int _val, List<Node> _children) {
     *          val = _val;
     *          children = _children;
     *     }
     * }
     */
    class Node {
        int val;
        List<Node> children;
        Node() {}
        Node(int _val) {
            val = _val;
        }
        Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    public void dfs(Node root, List<Integer> res) {
        if (root == null)
            return;
        for (Node i : root.children) {
            dfs(i, res);
        }
        res.add(root.val);
    }
}
