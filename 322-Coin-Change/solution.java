public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] nums = new int[amount + 1];
        Arrays.fill(nums, amount + 1);
        nums[0] = 0;
        Arrays.sort(coins);
        for(int i = 1; i < amount + 1; i++) {
            for(int j = 0; j < coins.length; j++) {
                int k = 1;
                while(i - k * coins[j] >= 0){
                    nums[i] = Math.min(nums[i], nums[i - k * coins[j]] + k);
                    k++;
                }
            }
        }
        return nums[amount] == amount + 1 ? -1 : nums[amount];
    }
}