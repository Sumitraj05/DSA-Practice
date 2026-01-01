class Solution {

    public void dfs(char[][] board, int[][] vis, int sr, int sc, int[] delrow, int[] delcol){
        vis[sr][sc] = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                dfs(board, vis, nrow, ncol, delrow, delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i = 0; i<m; i++){
            if(board[0][i] == 'O' && vis[0][i] == 0) dfs(board, vis, 0, i, delrow, delcol);
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0) dfs(board, vis, n-1, i, delrow, delcol);
        }

        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O' && vis[i][0] == 0) dfs(board, vis, i, 0, delrow, delcol);
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) dfs(board, vis, i, m-1, delrow, delcol);
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
