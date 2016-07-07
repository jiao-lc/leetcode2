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
        }else{
            while(q.next!=null){
                p=p.next;
                q=q.next;
            }
            q.next=head;
            head=p.next;
            p.next=null;
        }
        return head;
    }
}