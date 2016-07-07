public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = n / 2;
        int col = n / 2;
        if (n % 2 != 0) {
            col++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}