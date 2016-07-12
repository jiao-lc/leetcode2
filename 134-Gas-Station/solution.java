public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0, need = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if(cur < 0) {
                start = i + 1;
                need -= cur;
                cur = 0;
            }
        }
        if(cur - need >= 0) return start;
        return -1;
    }
}