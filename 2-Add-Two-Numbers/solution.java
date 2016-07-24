/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int cur;
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1 != null && l2 != null) {
            cur = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode tmp = new ListNode(cur);
            head.next = tmp;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
    
        if(l1 == null) {
            l1 = l2;
        }
        while(carry != 0 && l1 != null) {
            cur = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
        }
        if(l1 != null) {
            head.next = l1;
        }
        if(carry > 0) {
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }
}