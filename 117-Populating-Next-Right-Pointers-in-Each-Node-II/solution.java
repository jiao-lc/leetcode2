/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode head = dummy;
        while(root != null) {
            while(root != null) {
                if(root.left != null) {
                    head.next = root.left;
                    head = head.next;
                }
                if(root.right != null) {
                    head.next = root.right;
                    head = head.next;
                }
                root = root.next;
            }
            root = dummy.next;
            head = dummy;
            head.next = null;
        }
    }
}