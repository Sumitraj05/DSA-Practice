class Solution {
    public void dfs(char[][] grid, int sr, int sc, int[] delrow, int[] delcol, int n, int m){
        grid[sr][sc] = '0';
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1'){
                dfs(grid, nrow, ncol, delrow, delcol, n, m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, delrow, delcol, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }
}
