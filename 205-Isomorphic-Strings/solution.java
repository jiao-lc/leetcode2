public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null)  return true;
        if(s.length() != t.length()) return false;
        char[] map = new char[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for(int i = 0; i < ss.length; i++) {
            if(map[ss[i] - 'a'] != 0) {
                if(map[ss[i] - 'a'] != tt[i]) return false;
            } else {
                map[ss[i] - 'a'] = tt[i];
            }
        }
        return true;
    }
}