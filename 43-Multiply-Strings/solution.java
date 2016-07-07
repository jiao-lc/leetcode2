public class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int len1 = num1.length(), len2 = num2.length();
        for(int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for(int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[len1 - 1 - i + len2 - 1 - j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for(int i = 0; i < len1 + len2; i++) {
            int sum = c + res[i];
            c = sum / 10;
            res[i] = sum % 10;
        }
        for(int i = len1 + len2 - 1; i >= 0; i--) {
            if(res[i] == 0 && sb.length() == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}