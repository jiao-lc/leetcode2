public class Solution {
    public int longestConsecutive(int[] nums) {
    
    Set<Integer> set = new HashSet<Integer>();
    
    for(int n: nums) set.add(n);
    
    int max = 0;
    
    for(int n: nums){
        int count = 0;
        if(set.isEmpty()) break;
        
        int val = n;
        while(set.remove(val--))
            count ++;
        
        val = n;
        while(set.remove(++val))
            count ++;
        
        max = Math.max(count,max);
    }
    
    return max;

    }
}