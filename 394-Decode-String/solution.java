public class Solution {
    class StringNum {
        public StringBuilder sb = new StringBuilder();
        public int times;
    }
    public String decodeString(String s) {
        Stack<StringNum> stk = new Stack<StringNum>();
        char[] arr = s.toCharArray();
        int num = 0;
        StringNum cur = new StringNum();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= '0' && arr[i] <= '9') {
                int start = i;
                while(i < arr.length && arr[i] >= '0' && arr[i] <= '9') i++;
                cur.times = Integer.parseInt(s.substring(start, i));
                i--;
            } else if (Character.isLetter(arr[i])) {
                int start = i;
                while(i < arr.length && Character.isLetter(arr[i])) i++;
                cur.sb.append(s.substring(start, i));
                i--;
            } else if(arr[i] == '[') {
                stk.push(cur);
                cur = new StringNum();
            } else if(arr[i] == ']') {
                String post = cur.sb.toString();
                cur = stk.pop();
                for(int j = 0; j < cur.times; j++) cur.sb.append(post);
            }
        }
        return cur.sb.toString();
    }
}