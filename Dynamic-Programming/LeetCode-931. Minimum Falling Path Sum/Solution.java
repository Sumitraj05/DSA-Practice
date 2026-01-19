// Memoization
class Solution {
    public int solve(int[][] dp, int row, int col, int[][] matrix, int n){
        if(col < 0 || col > n-1){
            return 100000009;
        }
        if(row == n-1){
            return matrix[row][col];
        }
        if(dp[row][col] != -100000009) return dp[row][col];
        int down = matrix[row][col] + solve(dp, row+1, col, matrix, n);
        int left_dia = matrix[row][col] + solve(dp, row+1, col-1, matrix, n);
        int right_dia = matrix[row][col] + solve(dp, row+1, col+1, matrix, n);
        return dp[row][col] = Math.min(down, Math.min(left_dia, right_dia));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -100000009);
        }
        for(int i = 0; i<n; i++){
            min = Math.min(min, solve(dp, 0, i, matrix, n));
        }
        return min;
    }
}
