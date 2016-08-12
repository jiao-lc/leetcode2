public class Solution {
    public boolean searchMatrix(int[][] matrix, int x) {
        int m = matrix.length - 1, n = 0;
		while(m >= 0 && m < matrix.length && n >= 0 && n < matrix[0].length) {
			if(matrix[m][n] == x)
				return true;
			if(matrix[m][n] > x) {
				m--;
			} else {
				n++;
			}
		}
		return false;
    }
}