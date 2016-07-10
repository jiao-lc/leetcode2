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
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Queue<TreeLinkNode> tmp = new LinkedList<TreeLinkNode>();
            TreeLinkNode prev = null;
            while(!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                if(prev != null) {
                    prev.next = node;
                }
                if(node.left != null)   tmp.add(node.left);
                if(node.right != null)  tmp.add(node.right);
                prev = node;
            }
            queue = tmp;
        }
    }
}