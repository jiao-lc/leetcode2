public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0) return "0";
        String[] dig = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dig[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(dig, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String t1 = str1 + str2;
                String t2 = str2 + str1;
                return t2.compareTo(t1);
            }
        });
        StringBuilder sb = new StringBuilder();
        if(dig[0].equals("0")) return "0";
        for(String str : dig) {
            sb.append(str);
        }
        return sb.toString();
    }
}