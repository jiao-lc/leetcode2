public class Solution {
    class Pair {
        int idx1;
        int idx2;
        int sum;
        Pair(int i, int j, int s) {
            idx1 = i;
            idx2 = j;
            sum = s;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, (a, b) -> (a.sum - b.sum));
        queue.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        Set<int[]> res = new HashSet<int[]>();
        while(res.size() < k && !queue.isEmpty()) {
            Pair tmp = queue.poll();
            int x = tmp.idx1, y = tmp.idx2;
            if(res.add(new int[]{nums1[x], nums2[y]})) {
                if(x < nums1.length - 1)
                    queue.offer(new Pair(x + 1, y, nums1[x + 1] + nums2[y]));
                if(y < nums2.length - 1)
                    queue.offer(new Pair(x, y + 1, nums1[x] + nums2[y + 1]));
            }
        }
        List<int[]> ret = new ArrayList<int[]>(res);
        return ret;
    }
}