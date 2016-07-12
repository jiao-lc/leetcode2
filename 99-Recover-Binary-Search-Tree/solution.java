/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        boolean firstTime = true;
        TreeNode m = null, n = null, pre = null;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode node = stack.pop();
            if (pre != null && pre.val > node.val) {
                if (firstTime) {
                    m = pre;
                    firstTime = false;
                }
                n = node;
            }
            pre = node;
            root = node.right;
        }
        int tmp = m.val;
        m.val = n.val;
        n.val = tmp;
    }
}