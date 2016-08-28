public class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
		for(char a : s.toCharArray()) {
			ans = ans ^ a;
		}
		for(char b : t.toCharArray()) {
			ans = ans ^ b;
		}
		return (char)ans;
    }
}