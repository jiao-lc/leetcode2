public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)    return true;
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j) {
            while(!Character.isLetter(arr[i])) i++;
            while(!Character.isLetter(arr[j])) j--;
            if(arr[i] == arr[j] || Math.abs(arr[i] - arr[j]) == 32) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}