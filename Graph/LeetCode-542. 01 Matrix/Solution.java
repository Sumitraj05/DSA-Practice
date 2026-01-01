class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1;
                }
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            dist[row][col] = steps;
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1){
                    q.add(new int[]{nrow, ncol, steps+1});
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dist;
    }
}
