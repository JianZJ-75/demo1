package Feb_2024;

import java.util.*;

/**
 * @Author 22798
 * @Date 2024/2/17 17:22
 */
public class Solution_2024_2_17 {
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
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> res = new ArrayList<>();
         int k = 0, cnt = 1, mx = 1;
         Deque<Node> dq = new LinkedList<>();
         if (root != null)
            dq.addLast(root);
         while (!dq.isEmpty())
         {
             if (k == 0 && mx == cnt)
                 res.add(new ArrayList<>());
             Node t = dq.pollFirst();
             res.get(res.size() - 1).add(t.val);
             for (Node i : t.children) {
                 dq.addLast(i);
                 k++;
             }
             cnt--;
             if (cnt == 0)
             {
                 mx = k;
                 cnt = k;
                 k = 0;
             }
         }
         return res;
    }
}