public class Solution {
    int d;
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int[] step = new int[1];
        Set<String> used = new HashSet<String>();
        helper(beginWord, endWord, wordList, used, step);
        return d;
    }
    public void helper(String cur, String end, Set<String> wordList, Set<String> used, int[] step) {
        if(cur.equals(end)) {
            d = step[0];
            return;
        }
        if(used.size() == wordList.size()) {
            return;
        }
        for(String word : wordList) {
            if(oneDiff(word, cur)) {
                used.add(cur);
                step[0]++;
                helper(word, end, wordList, used, step);
                step[0]--;
                used.remove(cur);
            }
        }
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