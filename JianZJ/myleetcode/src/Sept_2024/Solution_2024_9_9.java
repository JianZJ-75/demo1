package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/9 20:14
 */
public class Solution_2024_9_9 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode();
        ListNode tmp = root;
        int sum = 0;
        while (head.next != null) {
            head = head.next;
            if (head.val == 0) {
                ListNode t = new ListNode(sum);
                tmp.next = t;
                tmp = t;
                sum = 0;
            } else {
                sum += head.val;
            }
        }
        return root.next;
    }
}