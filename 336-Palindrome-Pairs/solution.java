public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                if(check(words, i, j)) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    
    private boolean check(String[] words, int i, int j) {
        String checked = words[i] + words[j];
        int start = 0, end = checked.length() - 1;
        while(start < end) {
            if(checked.charAt(start) != checked.charAt(end))
            return false;
            start++; end--;
        }
        return true;
    }
}