/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), large = new ListNode(0);
        ListNode s = small, l = large;
        while(head != null) {
            if(head.val >= x) {
                l.next = head;
                l = l.next;
            } else {
                s.next = head;
                s = s.next;
            }
            head = head.next;
            l.next = null;
            s.next = null;
        }
        s.next = large.next;
        return small.next;
    }
}