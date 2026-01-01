// User function Template for Java

class Solution {
    
    public void dfs(int[][] grid, int sr, int sc, int[] delrow, int[] delcol, int n, int m, ArrayList<Integer> vec, int[][] vis, int row0, int col0){
        vis[sr][sc] = 1;
        vec.add(sr-row0);
        vec.add(sc-col0);
        for(int i = 0; i<4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1){
                dfs(grid, nrow, ncol, delrow, delcol, n, m, vec, vis, row0, col0);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    ArrayList<Integer> vec = new ArrayList<>();
                    dfs(grid, i, j, delrow, delcol, n, m, vec, vis, i, j);
                    set.add(vec);

                }
            }
        }
        return set.size();
    }
}
