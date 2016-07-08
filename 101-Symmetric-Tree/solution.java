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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return childrenSym(root.left, root.right);
    }
    public boolean childrenSym(TreeNode left, TreeNode right) {
        if(left == null && right == null)   return true;
        if(left == null || right == null)   return false;
        if(left.val != right.val)   return false;
        return childrenSym(left.left, right.right) && childrenSym(left.right, right.left);
    }
}