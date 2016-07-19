public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k, (a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        for(int i : nums1) {
            for(int j : nums2) {
                queue.add(new int[]{i, j});
            }
        }
        List<int[]> res = new ArrayList<int[]>();
        while(k > 0 && !queue.isEmpty()) {
            res.add(queue.poll());
            k--;
        }
        return res;
    }
}