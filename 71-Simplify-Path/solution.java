public class Solution {
    public String simplifyPath(String path) {
        String[] tmp = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String str : tmp) {
            if(str == null || str.length() == 0 || str.equals(".")) continue;
            if(str.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        String res = "";
        while(!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}