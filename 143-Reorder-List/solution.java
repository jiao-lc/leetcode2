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
        fast = slow.next;
        slow.next = null;
        Stack<ListNode> stack = new Stack<>();
        while(fast != null) {
            stack.push(fast);
            fast = fast.next;
        }
        slow = head;
        while(!stack.empty()) {
            ListNode node = stack.pop();
            ListNode tmp = slow.next;
            slow.next = node;
            node.next = tmp;
            slow = tmp;
        }
    }
}