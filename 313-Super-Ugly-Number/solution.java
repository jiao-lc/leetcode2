public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] res = new int[n];
        int[] index = new int[len];
        res[0] =1;
        if(n<=1) return res[0];
        for(int i=1;i<n;i++) {
            int num = Integer.MAX_VALUE;
            for(int j=0;j<len;j++) {
                num = Math.min(num, primes[j] * res[index[j]]);
            }
            res[i] = num;
            for(int j=0;j<len;j++) {
                if(res[i] % primes[j]==0) index[j]++;
            }
        }
        return res[n-1];
    }
}