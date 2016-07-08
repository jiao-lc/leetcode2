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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || inorder == null || preorder == null || preorder.length == 0)    return null;
        if(preorder.length == 1)    return new TreeNode(preorder[0]);
        return buildSub(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode buildSub(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr || il > ir || pl >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int indx = il;
        while(inorder[indx] != root.val) indx++;
        
        root.left = buildSub(preorder, inorder, pl + 1, pl + indx - il, il, indx - 1);
        root.right = buildSub(preorder, inorder, pl + indx - il + 1, pr, indx + 1, ir);
        return root;
    }
}