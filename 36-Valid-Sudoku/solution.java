public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')  continue;
                int indx = 1 << (board[i][j] - '0');
                if((indx & vset[j]) > 0 || (indx & hset[i]) > 0 || (indx & bckt[i / 3 * 3 + j / 3]) > 0)    return false;
                hset[i] |= indx;
                vset[j] |= indx;
                bckt[(i / 3) * 3 + j / 3] |= indx;
            }
        }
        return true;
    }
}