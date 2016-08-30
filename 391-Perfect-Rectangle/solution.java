public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        HashMap<String, Integer> cor2type = new HashMap<>();
        int lx = Integer.MAX_VALUE, ly = lx, rx = Integer.MIN_VALUE, ry = rx, sum = 0;
        for(int[] rec : rectangles) {
            lx = Math.min(lx, rec[0]);
            ly = Math.min(ly, rec[1]);
            rx = Math.max(rx, rec[2]);
            ry = Math.max(ry, rec[3]);
            sum += (rec[3] - rec[1]) * (rec[2] - rec[0]);
            if(overlap(cor2type, rec[0] + "," + rec[1], 1)) return false;
            if(overlap(cor2type, rec[2] + "," + rec[1], 2)) return false;
            if(overlap(cor2type, rec[2] + "," + rec[3], 4)) return false;
            if(overlap(cor2type, rec[0] + "," + rec[3], 8)) return false;
        }
        int cnt = 0;
        for(String str : cor2type.keySet()) {
            int val = cor2type.get(str);
            if(val == 1 || val == 2 || val == 4 || val == 8) cnt++;
        }
        return cnt == 4 && sum == (ry - ly) * (rx - lx);
    }
    public boolean overlap(HashMap<String, Integer> map, String key, int type) {
        Integer val = map.get(key);
        if(val == null) {
            map.put(key, type);
        } else if((val & type) != 0) {
            return true;
        } else {
            map.put(key, val | type);
        }
        return false;
    }
}