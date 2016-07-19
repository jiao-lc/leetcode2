public class Solution {
  public int getMoneyAmount(int n) {
    int[][] table = new int[n + 1][n + 1];  //0
    return payForRange(table, 1, n);
  }

  //return the amount paid for the game within range [start,end]
  private int payForRange(int[][] dp, int start, int end) {
    if (start >= end)
      return 0;
    if (dp[start][end] != 0)
      return dp[start][end];

    int minimumForCurrentRange = Integer.MAX_VALUE;
    for (int x = start; x <= end; ++x) {
      //calculate the amount to pay if pick x.
      int pay = x + Math.max(payForRange(dp, start, x - 1), payForRange(dp, x + 1, end));
      //calculate min of maxes
      minimumForCurrentRange = Math.min(minimumForCurrentRange, pay);
    }

    dp[start][end] = minimumForCurrentRange;
    return minimumForCurrentRange;
  }
}