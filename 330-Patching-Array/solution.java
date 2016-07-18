public class Solution {
    public int minPatches(int[] nums, int n) {
        int cnt = 0, range = 0;
        int i = 0;
        while(range < n && range >= 0) { //range >= 0  overflow
            if(i < nums.length && nums[i] <= range + 1) {
                range+= nums[i];
                i++;
            }
            else {
                cnt++;
                range = 2 * range + 1;
            }
        }
        return cnt;
    }
}