public class Solution {
    class SegmentTreeNode {
	    int start;
    	int end;
    	int val;
    	SegmentTreeNode left;
    	SegmentTreeNode right;
    	SegmentTreeNode(int s, int e, int v) { start = s; end = e; val = v;}
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        SegmentTreeNode root = new SegmentTreeNode(0, Integer.MAX_VALUE, 0);
        for(int[] build : buildings) {
            root = insert(root, build[0], build[1], build[2]);
        }
        fill(res, root, 0);
        if(res.get(res.size() - 1)[1] != 0)
            res.add(new int[]{Integer.MAX_VALUE, 0});
        return res;
    }
    public SegmentTreeNode insert(SegmentTreeNode root, int s, int e, int v) {
        if(root.start >= s && root.end <= e) {
    		root.val = Math.max(root.val, v);
    		return root;
    	}
    	if(root.end <= s || root.start >= e)	return root;
    	if(root.start < s) {
    		if(root.right == null){
    			root.right = new SegmentTreeNode(s, root.end, root.val);
    			root.left = new SegmentTreeNode(root.start, s, root.val);
    		}
    	} 
    	if(root.end >= e) {
    		if(root.left == null){
    			root.left = new SegmentTreeNode(root.start, e, root.val);
    			root.right = new SegmentTreeNode(e, root.end, root.val);
    		}
    	} 
    	root.left = insert(root.left, s, e, v);
		root.right = insert(root.right, s, e, v);
    	return root;
    }
    public void fill(List<int[]> res, SegmentTreeNode root, int cur) {
		if(root == null)  return;
		Stack<SegmentTreeNode> st = new Stack<SegmentTreeNode>();
		while(!st.empty() || root != null) {
		    while(root != null) {
		        st.push(root);
		        root = root.left;
		    }
		    root = st.pop();
		    if(isLeaf(root)) {
		        if(root.val != cur) {
		            res.add(new int[]{root.start, root.val});
		            cur = root.val;
		        }
		    }
		    root = root.right;
		}
	}
    public boolean isLeaf(SegmentTreeNode node) {
        if(node == null) return false;
        if(node.left == null && node.right == null) return true;
        return false;
    }
}