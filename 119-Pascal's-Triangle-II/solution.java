public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = res.size() - 2; j > 0; j--) {
                int tmp = res.get(j) + res.get(j - 1);
                res.set(j, tmp);
            }
        }
        return res;
    }
}