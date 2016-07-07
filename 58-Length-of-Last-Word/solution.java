public class Solution {
    public int lengthOfLastWord(String s) {
        char[] str = s.toCharArray();
        if(str.length == 0) return 0;
        int cnt = 0;
        for(int i = str.length - 1; i >= 0; i--) {
            if(str[i] == ' ' && cnt == 0)   continue;
            if(str[i] == ' ' && cnt > 0)    break;
            cnt++;
        }
        return cnt;
    }
}