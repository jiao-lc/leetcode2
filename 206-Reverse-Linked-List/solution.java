/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode tmp = head.next;
        head.next = null;
        ListNode newHead = reverseList(tmp);
        tmp.next = head;
        return newHead;
    }
}