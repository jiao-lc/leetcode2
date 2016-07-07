/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)   return head;
        ListNode p = head, q = head;
        while(k > 0 && p != null) {
            p = p.next; k--;
        }
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }
}