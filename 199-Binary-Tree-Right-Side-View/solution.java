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
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int q = queue.size();
            for(int i = 0; i < q; i++) {
                root = queue.poll();
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
            }
            res.add(root.val);
        }
        return res;
    }
}