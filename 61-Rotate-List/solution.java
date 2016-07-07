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
        if(head == null || head.next == null || k == 0)   return head;
        ListNode p = head, q = head;
        
        int step=0;
        while(step < k && q != null){
            q = q.next;
            step++;
        }
        if(q == null){
            return rotateRight(head, k%step);
        }
        while(p != null && p.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }
}