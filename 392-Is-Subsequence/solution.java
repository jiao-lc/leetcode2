public class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        boolean available = true;
        for(char c : s.toCharArray()) {
            if(!available) {
                return false;
            }
            available = false;
            for(int i = start; i < t.length(); i++) {
                if(c == t.charAt(i)) {
                    start = i + 1;
                    available = true;
                    break;
                }
            }
        }
        return available;
    }
}