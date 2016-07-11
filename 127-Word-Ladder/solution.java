public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int[] step = new int[1];
        Set<String> used = new HashSet<String>();
        int ans = helper(beginWord, endWord, wordList, used, 0);
        return ans;
    }
    public int helper(String cur, String end, Set<String> wordList, Set<String> used, int step) {
        if(cur.equals(end)) {
            return step;
        }
        if(used.size() == wordList.size()) {
            return 0;
        }
        for(String word : wordList) {
            if(oneDiff(word, cur)) {
                used.add(cur);
                step = helper(word, end, wordList, used, step + 1);
                if(step != 0)   return step;
                used.remove(cur);
            }
        }
        return 0;
    }
    
    public boolean oneDiff(String w1, String w2) {
        if(w1.length() != w2.length())  return false;
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();
        int cnt = 0;
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i])  cnt++;
        }
        return cnt == 1;
    }
}