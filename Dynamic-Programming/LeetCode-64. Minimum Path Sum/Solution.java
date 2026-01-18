// Memoization
class Solution {
    public int solve(int[][] dp, int[][] grid, int m, int n){
        if(m == 0 && n == 0) return grid[m][n];
        if(m < 0 || n < 0) return 100000009;
        if(dp[m][n] != -1) return dp[m][n];
        int up = grid[m][n] + solve(dp, grid, m-1, n);
        int left = grid[m][n] + solve(dp, grid, m, n-1);
        return dp[m][n] = Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(dp, grid, m-1, n-1);
    }
}

// Bottom Up
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;  
                } 
                int down = 1000000009;
                int right = 1000000009;
                if(i > 0){
                    down = grid[i][j] + dp[i-1][j];
                }
                if(j > 0){
                    right = grid[i][j] + dp[i][j-1];
                }
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[m-1][n-1];
    }
}

// Space Optimization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
                if(i == 0 && j == 0){
                    temp[j] = grid[0][0];
                    continue;  
                } 
                int down = 100000009;
                int right = 10000009;
                if(i > 0){
                    down = grid[i][j] + prev[j];
                }
                if(j > 0){
                    right = grid[i][j] + temp[j-1];
                }
                temp[j] = Math.min(right, down);
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
