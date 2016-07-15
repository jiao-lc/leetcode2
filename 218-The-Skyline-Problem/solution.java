public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<int[]>();
        List<int[]> res = new ArrayList<int[]>();
        for(int[] build : buildings) {
            heights.add(new int[]{build[0], -build[2]});
            heights.add(new int[]{build[1], build[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] height : heights) {
            if(height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            int cur = pq.peek();
            if(cur != prev) {
                res.add(new int[]{height[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}