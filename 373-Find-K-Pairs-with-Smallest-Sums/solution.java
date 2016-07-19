public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k,new Comparator<int[]>(){
           public int compare(int[] a,int[] b){
                return -a[0]-a[1]+b[0]+b[1];
           } 
        });
        List<int[]> res = new ArrayList<>();
        for(int i =0;i<k&&i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int[] cur = new int[2];
                cur[0] = nums1[i];
                cur[1] = nums2[j];
                if(heap.size()<k)
                    heap.offer(cur);
                else{
                    int[] top = heap.peek();
                    if(top[0]+top[1]>cur[0]+cur[1]){
                        heap.poll();
                        heap.offer(cur);
                    }
                }
            }
        }
        for(int[] a: heap){
            res.add(a);
        }
        return res;
    }
}