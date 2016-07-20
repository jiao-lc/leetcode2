public class Solution {
    final int[][] neighbors = {{0, 1}, {1, 0}};
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list;
        }
        int m = nums1.length, n = nums2.length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;
        while (k > 0 && !minHeap.isEmpty()) {
            Pair min = minHeap.poll();
            list.add(new int[] {nums1[min.row], nums2[min.col]});
            k--;
            for (int[] neighbor : neighbors) {
                int row1 = min.row + neighbor[0];
                int col1 = min.col + neighbor[1];
                if (row1 < 0 || row1 == m || col1 < 0 || col1 == n || visited[row1][col1]) {
                    continue;
                }
                visited[row1][col1] = true;
                minHeap.offer(new Pair(row1, col1, nums1[row1] + nums2[col1]));
            }
        }
        return list;
    }
}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int value;
    
    Pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    public int compareTo(Pair other) {
        return value - other.value;
    } 
}