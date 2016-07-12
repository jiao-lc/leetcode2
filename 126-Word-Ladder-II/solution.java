public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        Queue<List<String>> queue = new LinkedList<List<String>>();
        wordList.remove(endWord);
        wordList.remove(beginWord);
        boolean stop = false;
        list.add(beginWord);
        queue.add(list);
        while(queue.size() != 0 && !stop) {
            int qSize = queue.size();
            HashSet<String> dup = new HashSet<String>();
            for(int q = 0; q < qSize; q++) {
                List<String> tmp = queue.poll();
                String cur = tmp.get(tmp.size() - 1);
                char[] chs = cur.toCharArray();
                for(int i = 0; i < chs.length; i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(chs[i] == c) continue;
                        char back = chs[i];
                        chs[i] = c;
                        String check = new String(chs);
                        if(check.equals(endWord)) {
                            tmp.add(endWord);
                            res.add(new ArrayList<String>(tmp));
                            stop = true;
                            tmp.remove(tmp.size() - 1);
                        }
                        if(wordList.contains(check)) {
                            tmp.add(check);
                            queue.add(new ArrayList<String>(tmp));
                            tmp.remove(tmp.size() - 1);
                            dup.add(check);
                        }
                        chs[i] = back;
                    }
                }
            }
            wordList.removeAll(dup);
        }
        return res;
    }
}