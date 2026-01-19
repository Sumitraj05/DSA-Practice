// Memoization
class Solution {
    public int solve(int[][] dp, int n, int W, int val[], int wt[]){
        if(n == 0){
            if(wt[n] <= W) return val[n];
            return 0;
        }
        if(dp[n][W] != -1) return dp[n][W];
        int not_take = solve(dp, n-1, W, val, wt);
        int take = Integer.MIN_VALUE;
        if(wt[n] <= W){
            take = val[n] + solve(dp, n-1, W-wt[n], val, wt);
        }
        return dp[n][W] = Math.max(take, not_take);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][W+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, n-1, W, val, wt);
    }
}

// Bottom Up
class Solution {
    public int knapsack(int W, int val[], int wt[]) {

        int n = wt.length;
        int[][] dp = new int[n][W + 1];

        // Base case: item 0
        for (int w = wt[0]; w <= W; w++) {
            dp[0][w] = val[0];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {

                int notTake = dp[i - 1][w];
                int take = 0;

                if (wt[i] <= w) {
                    take = val[i] + dp[i - 1][w - wt[i]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }
}

