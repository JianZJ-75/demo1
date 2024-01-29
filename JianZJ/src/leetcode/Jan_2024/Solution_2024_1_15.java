package leetcode.Jan_2024;

/**
 * @Author: JianZJ
 * @Date: 2024/1/15 2:07
 */
public class Solution_2024_1_15 {
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode();
        t.next = head;
        ListNode i = t;
        while (i.next != null) {
            int len = 0;
            ListNode j = i;
            while (j.next != null && i.next.val == j.next.val) {
                len++;
                j = j.next;
            }
            if (len != 1)
                i.next = j.next;
            else
                i = i.next;
        }
        return t.next;
    }
}
