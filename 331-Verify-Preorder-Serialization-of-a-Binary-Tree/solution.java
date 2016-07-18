public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] vals = preorder.split(",");
        int i = 0;
        Stack<String> st = new Stack<String>();
        st.push("0");
        for( ; i < vals.length; i++) {
            if(!vals[i].equals("#")) st.push(vals[i]);
            else {
                if(st.peek() == null) break;
                st.pop();
            }
        }
        return st.empty() && i == vals.length;
    }
}