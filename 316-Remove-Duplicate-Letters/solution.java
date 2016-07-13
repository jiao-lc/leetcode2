public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int pos = 0;
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<Character>();
        char[] ch = s.toCharArray();
        for(char c : ch) {
            count[c - 'a']++;
        }
        for(char c : ch) {
            pos = c - 'a';
            count[pos]--;
            if(visited[pos]) continue;
            while(!st.empty() && st.peek() > c  && count[st.peek() - 'a'] > 0) visited[st.pop() - 'a'] = false;
            st.push(c);
            visited[pos] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}