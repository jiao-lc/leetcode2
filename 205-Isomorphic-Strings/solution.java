public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null)  return true;
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] m1 = new int[256], m2 = new int[256];
        for(int i = 0; i < ss.length; i++) {
            if (m1[ss[i]] != m2[tt[i]]) return false;
            m1[ss[i]] = i + 1;
            m2[tt[i]] = i + 1;
        }
        return true;
    }
}