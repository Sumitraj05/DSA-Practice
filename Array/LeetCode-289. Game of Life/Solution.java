class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dirs = {-1, 0, 1};

        // First pass: mark transitions
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                int live = 0;

                // count live neighbors
                for(int dx : dirs){
                    for(int dy : dirs){
                        if(dx == 0 && dy == 0) continue;

                        int r = i + dx;
                        int c = j + dy;

                        if(r>=0 && r<m && c>=0 && c<n
                           && Math.abs(board[r][c]) == 1){
                            live++;
                        }
                    }
                }

                // apply rules
                if(board[i][j] == 1){
                    if(live < 2 || live > 3)
                        board[i][j] = -1; // live -> dead
                } 
                else{
                    if(live == 3)
                        board[i][j] = 2; // dead -> live
                }
            }
        }

        // Second pass: finalize states
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}
