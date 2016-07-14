public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int gap = (max - min - 1) / (nums.length - 1) + 1;
        int[] bucketsMIN = new int[nums.length - 1];
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for(int i : nums) {
            if(i == max || i == min) continue;
            int idx = (i - min) / gap;
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i< nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)  continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}