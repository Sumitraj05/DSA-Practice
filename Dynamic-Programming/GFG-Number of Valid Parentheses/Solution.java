class Solution {
    int findWays(int n) {
        // code here
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(dp, n, 0);
    }
    
    int solve(int[][] dp, int n, int open){
        if(n < open) return 0;
        if(open == n) return 1;
        
        if(dp[n][open] != -1) return dp[n][open];
        int op1 = solve(dp, n-1, open+1);
        int close = 0;
        if(open > 0){
            close = solve(dp, n-1, open-1);
        }
        return dp[n][open] = op1 + close;
    }
}
