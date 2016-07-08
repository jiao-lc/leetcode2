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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length == 0)    return null;
        return buildSub(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode buildSub(int[] postorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr || il > ir || pr < 0) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int indx = il;
        while(inorder[indx] != root.val) indx++;
        
        root.left = buildSub(postorder, inorder, pl, pl + indx - il - 1, il, indx - 1);
        root.right = buildSub(postorder, inorder, pl + indx - il, pr - 1, indx + 1, ir);
        return root;
    }
}