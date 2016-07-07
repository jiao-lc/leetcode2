public class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt=0;
        int len=0;
        for(int i=0;i<nums.length;++i){
            if(i==0 || nums[i]!=nums[i-1]){
                cnt = 1;
            }else{
                cnt++;
            }
            if(cnt<3){
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}