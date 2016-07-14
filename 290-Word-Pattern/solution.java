public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] pat = pattern.toCharArray();
        String[] s = str.split(" ");
        if(pat.length != s.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < pat.length; i++) {
            char c = pat[i];
            if(!map.containsKey(c)) map.put(c, s[i]);
            else if(!map.get(c).equals(s[i])) return false;
        }
        for(int i = 0; i < pat.length; i++) {
            String c = s[i];
            if(!map2.containsKey(c)) map2.put(c, pat[i]);
            else if(map2.get(c) != pat[i]) return false;
        }
        return true;
    }
}