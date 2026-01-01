class Solution {
    public void dfs(int[][] board, int[][] vis, int sr, int sc, int[] delrow, int[] delcol){
        vis[sr][sc] = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                dfs(board, vis, nrow, ncol, delrow, delcol);
            }
        }
    }

    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i = 0; i<m; i++){
            if(board[0][i] == 1 && vis[0][i] == 0) dfs(board, vis, 0, i, delrow, delcol);
            if(board[n-1][i] == 1 && vis[n-1][i] == 0) dfs(board, vis, n-1, i, delrow, delcol);
        }

        for(int i = 0; i<n; i++){
            if(board[i][0] == 1 && vis[i][0] == 0) dfs(board, vis, i, 0, delrow, delcol);
            if(board[i][m-1] == 1 && vis[i][m-1] == 0) dfs(board, vis, i, m-1, delrow, delcol);
        }

    //    for(int i = 0; i<n; i++){
    //         for(int j = 0; j<m; j++){
    //             if(i == 0 || j == 0 || i == n-1 || j == m-1){
    //                 if(board[i][j] == 1 && vis[i][j] == 0){
    //                     dfs(board, vis, i, j, delrow, delcol);
    //                 }
    //             }
    //         }
    //     } 

        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
