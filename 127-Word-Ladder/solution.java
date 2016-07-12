public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> myQueue = new LinkedList<String>();
        myQueue.offer(beginWord);
        int level = 1;
        HashSet<String> used = new HashSet<>(wordList);
        while(!myQueue.isEmpty()) {
            int qSize = myQueue.size();
            for(int i = 0; i < qSize; i++) {
                String tmp = myQueue.poll();
                if(tmp.equals(endWord))    return level;
                for(int j = 0; j < tmp.length(); j++) {
                    char[] arr = tmp.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String check = new String(arr);
                        if(!check.equals(tmp) && wordList.contains(check)){
                            myQueue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}