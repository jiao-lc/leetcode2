/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode h = dummy, t = head;
        h.next = head;
        int k = 1;
        while(k < n) {
            if(k < m) {
                h = t;
                t = t.next;
            } else if(k < n){
                ListNode tmp = h.next;
                h.next = t.next;
                t.next = t.next.next;
                h.next.next = tmp;
                
            }
            k++;
        }
        return dummy.next;
    }
}