public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dist = new int[len1 + 1][len2 + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for(int i = 0; i <= len1; i++) {
            dist[i][0] = i;
        }
        for(int j = 0; j <= len2; j++) {
            dist[0][j] = j;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(w1[i - 1] == w2[j - 1])  dist[i][j] = dist[i - 1][j - 1];
                else {
                    dist[i][j] = 1 + Math.min(dist[i - 1][j - 1], Math.min(dist[i][j - 1], dist[i - 1][j]));
                }
            }
        }
        return dist[len1][len2];
    }
}