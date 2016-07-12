public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num + 1) && !map.containsKey(num - 1)) {
                map.put(num, num);
            } else if(!map.containsKey(num + 1)) {
                map.put(num, map.get(num - 1));
            } else if(!map.containsKey(num - 1)) {
                map.put(num, map.get(num + 1));
            } else {
                map.put(num, map.get(num - 1));
                map = update(map, num + 1);
            }
        }
        int max = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>(); 
        for(Integer i : map.values()) {
            if(!cnt.containsKey(i)) {
                cnt.put(i, 0);
            }
            cnt.put(i, cnt.get(i) + 1);
            max = Math.max(max, cnt.get(i));
        }
        return max;
    }
    public HashMap<Integer, Integer> update(HashMap<Integer, Integer> map, int num) {
        int target = map.get(num - 1);
        while(map.containsKey(num)) {
            map.put(num, target);
            num++;
        }
        return map;
    }
}