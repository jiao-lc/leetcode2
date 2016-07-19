public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> lst = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0) return lst;
        int[] arr = new int[nums1.length];
        int start = 0;
        int max_length = nums2.length;
        int index = 0;
        int tempt = 0;
        while (k > 0 && start < arr.length) {
            int min = nums1[start] + nums2[arr[start]];
            index = start;
            for (int i = start + 1; i < arr.length; i ++) {
                tempt = nums1[i] + nums2[arr[i]];
                if (tempt < min) {
                    min = tempt;
                    index = i;
                }
                if (arr[i] == 0) break;
            }
            int[] result = {nums1[index], nums2[arr[index]]};
            lst.add(result);
            if (++arr[index] >= max_length) start++;
            k--;
        }
        return lst;
    }
}