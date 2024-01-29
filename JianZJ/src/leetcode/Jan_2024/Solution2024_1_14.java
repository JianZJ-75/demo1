package leetcode.Jan_2024;

/**
 * @Author: JianZJ
 * @Date: 2024/1/14 0:32
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution2024_1_14 {
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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode t = head;
        while (t != null && t.next != null) {
            if (t.val == t.next.val)
                t.next = t.next.next;
            else
                t = t.next;
        }
        return head;
    }
}
