public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> myQueue = new LinkedList<String>();
        myQueue.offer(beginWord);
        int level = 1;
        HashSet<String> used = new HashSet<>(wordList);
        while(!myQueue.isEmpty()) {
            int qSize = myQueue.size();
            for(int i = 0; i < qSize; i++) {
                String tmp = myQueue.poll();
                if(tmp.equals(endWord))    return level;
                for(String word : wordList) {
                    if(oneDiff(word, tmp)) {
                        myQueue.offer(word);
                        used.remove(word);
                    }
                }
                wordList = used;
            }
            level++;
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