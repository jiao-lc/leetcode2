public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] path = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(path[i][j] == 0)
                    path[i][j] = getMaxPath(matrix, path, i, j, Integer.MIN_VALUE);
                max = Math.max(max, path[i][j]);
            }
        }
        return max;
    }
    public int getMaxPath(int[][] matrix, int[][] path, int i, int j, int prev) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) return 0;
        if(path[i][j] != 0) return path[i][j];
        int left = getMaxPath(matrix, path, i, j - 1, matrix[i][j]);
        int right = getMaxPath(matrix, path, i, j + 1, matrix[i][j]);
        int up = getMaxPath(matrix, path, i - 1, j, matrix[i][j]);
        int down = getMaxPath(matrix, path, i + 1, j, matrix[i][j]);
        path[i][j] = 1 + Math.max(left, Math.max(right, Math.max(up, down)));
        return path[i][j];
    }
}