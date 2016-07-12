public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        
        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]) num[i] = num[i - 1] + 1;
        }
        int total = num[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) num[i] = Math.max(num[i + 1] + 1, num[i]);
            total += num[i];
        }
        return total + len;
    }
}