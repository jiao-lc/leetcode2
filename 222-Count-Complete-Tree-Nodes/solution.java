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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = 0, right = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            left++;
        }
        node = root;
        while(node != null) {
            node = node.right;
            right++;
        }
        if(left == right && left != 0) return (1 << left) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}