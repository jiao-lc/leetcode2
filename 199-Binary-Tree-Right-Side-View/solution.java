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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addRightSide(root,0,result);
        return result;
    }
    
    private void addRightSide(TreeNode root,int level, List<Integer> result){
        if(root == null) return ;
        if(result.size() == level) result.add(root.val); // only add if level is not present.
        addRightSide(root.right,level + 1, result);
        addRightSide(root.left,level + 1,result);

    }
}