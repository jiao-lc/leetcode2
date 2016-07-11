/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)   return;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        while(slow != null && fast != null) {
            ListNode tmps = slow.next;
            slow.next = fast;
            ListNode tmpf = fast.next;
            fast.next = tmps;
            slow = tmps;
            fast = tmpf;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode tmp = head.next;
        head.next = null;
        ListNode newHead = reverseList(tmp);
        tmp.next = head;
        return newHead;
    }
}