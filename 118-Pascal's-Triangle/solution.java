public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)    return res;
        int i = 0;
        List<Integer> prev = new ArrayList<Integer>();
        while(i < numRows) {
            List<Integer> tmp = new ArrayList<Integer>();
            if(i > 0)   prev = res.get(i - 1);
            for(int k = 0; k < i + 1; k++) {
                if(k == 0 || k == i) tmp.add(1);
                else tmp.add(prev.get(k) + prev.get(k - 1));
            }
            res.add(new ArrayList<Integer>(tmp));
            i++;
        }
        return res;
    }
}