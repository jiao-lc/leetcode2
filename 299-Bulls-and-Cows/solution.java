public class Solution {
    public String getHint(String secret, String guess) {
        char[] target = secret.toCharArray();
        char[] exp = guess.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : target) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        int a = 0, b = 0;
        for(int i = 0; i < exp.length; i++) {
            char c = exp[i];
            if(exp[i] == target[i]) {
                a++;
                map.put(c, map.get(c) - 1);
            }
            else if(map.containsKey(exp[i])) {
                map.put(c, map.get(c) - 1);
                b++;
            }
            if(map.containsKey(exp[i]) && map.get(exp[i]) == 0)
                map.remove(exp[i]);
        }
        return String.valueOf(a) + "A" + String.valueOf(b) + "B";
    }
}