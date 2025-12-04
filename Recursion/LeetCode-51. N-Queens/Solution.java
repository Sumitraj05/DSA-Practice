class Solution {
    // public boolean isValid(char[][] board, int row, int col){
    //     int duprow = row;
    //     int dupcol = col;
    //     int n = board.length;

    //     //Leftside
    //     while(col >= 0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         col--;
    //     }

    //     col = dupcol;
    //     //upleft
    //     while(row >= 0 && col >= 0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         row--;
    //         col--;
    //     }

    //     row = duprow;
    //     col = dupcol;
    //     //downleft
    //     while(row < n && col >= 0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         row++;
    //         col--;
    //     }
    //     return true;
    // }
    public void solve(int col, char[][] board, List<List<String>> ans, int n, HashSet<Integer> rowset, HashSet<Integer> uprowset, HashSet<Integer> downrowset){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        for(int i = 0; i<n; i++){
            if(!rowset.contains(i) && !uprowset.contains(i+col) && !downrowset.contains((n-1)+(i-col))){
                board[i][col] = 'Q';
                rowset.add(i);
                uprowset.add(i+col);
                downrowset.add((n-1)+(i-col));
                solve(col+1, board, ans, n, rowset, uprowset, downrowset);
                board[i][col] = '.';
                rowset.remove(i);
                uprowset.remove(i+col);
                downrowset.remove((n-1)+(i-col));
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        HashSet<Integer> rowset = new HashSet<>();
        HashSet<Integer> uprowset = new HashSet<>();
        HashSet<Integer> downrowset = new HashSet<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        solve(0, board, ans, n, rowset, uprowset, downrowset);
        return ans;
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
