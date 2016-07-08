public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dist = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++) {
            dist[i][0] = i;
        }
        for(int j = 0; j <= len2; j++) {
            dist[0][j] = j;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(word1.charAt(i) == word2.charAt(j))  dist[i][j] = dist[i - 1][j - 1];
                else {
                    dist[i][j] = 1 + Math.min(dist[i - 1][j - 1], Math.min(dist[i][j - 1], dist[i - 1][j]));
                }
            }
        }
        return dist[len1][len2];
    }
}