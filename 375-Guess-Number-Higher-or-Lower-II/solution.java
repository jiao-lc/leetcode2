public class Solution {
   public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        getRange(table, 1, n);
        return table[1][n];
    }
    public int getRange(int[][] table, int s, int e) {
        if(s >= e) return 0;
        if(table[s][e] != 0) return table[s][e];
        int currentRange = Integer.MAX_VALUE;
        for(int x = s; x <= e; x++) {
            int pay = x + Math.max(getRange(table, s, x - 1), getRange(table, x + 1, e));
            currentRange = Math.min(currentRange, pay);
        }
        table[s][e] = currentRange;
        return currentRange;
    }
}