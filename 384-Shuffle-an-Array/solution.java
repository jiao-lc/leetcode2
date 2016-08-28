public class Solution {
    public int[] array;
    public int[] original;
    public Solution(int[] nums) {
        array = new int[nums.length];
        original = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            original[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i = 0; i < array.length; i++) {
            array[i] = original[i];
        }
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 1; i < array.length; i++) {
            int k = rand(0, i);
            int tmp = array[k];
            array[k] = array[i];
            array[i] = tmp;
        }
        return array;
    }
    
    public int rand(int low, int high) {
        Random r = new Random();
        int d = r.nextInt(high - low + 1);
        return low + d;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */