public class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return cnt;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') cnt++;
                DFS(grid, i, j);
            }
        }
        return cnt;
    }
    public void DFS(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFS(grid, i + 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i - 1, j);
        DFS(grid, i, j - 1);
    }
}