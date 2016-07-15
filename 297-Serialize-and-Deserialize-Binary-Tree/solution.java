/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
 public String serialize(TreeNode root) {
     StringBuilder str = new StringBuilder();
     sdfs(str, root);
     return str.substring(0, str.length() - 1);
 }

  private void sdfs(StringBuilder str, TreeNode root) {
     if(root == null) str.append("#,");
     else {
         str.append(root.val + ",");
         sdfs(str, root.left);
         sdfs(str, root.right);
     }
 }
 
 public TreeNode deserialize(String data) {
     String[] nodes = ("#," + data).split(",");   
     TreeNode dummy = new TreeNode(0);
     ddfs(dummy, 0, nodes);
     return dummy.right;
 }
 
 private int ddfs(TreeNode root, int index, String[] nodes) {
     if(root == null) return index;
     else {
         String left = nodes[index++];
         if(!left.equals("#")) {
             root.left = new TreeNode(Integer.parseInt(left));
             index = ddfs(root.left, index, nodes);
         }
         String right = nodes[index++];
         if(!right.equals("#")) {
             root.right = new TreeNode(Integer.parseInt(right));
             index = ddfs(root.right, index, nodes);
         }
     }
     return index;
 }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));