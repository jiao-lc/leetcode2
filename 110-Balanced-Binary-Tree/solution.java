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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(dpth(root.left) - dpth(root.right)) <= 1;
    }
    public int dpth(TreeNode root) {
        if(root == null)    return 0;
        return 1 + Math.max(dpth(root.left), dpth(root.right));
    }
}