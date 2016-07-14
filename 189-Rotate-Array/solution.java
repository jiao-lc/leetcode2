public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        //find GCD between nums length and step
        int gcd = findGcd(nums.length, step);
        int position, count;
        
        //gcd path to finish movie
        for(int i = 0; i < gcd; i++){
            //beginning position of each path
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }
    
    public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }
    
}