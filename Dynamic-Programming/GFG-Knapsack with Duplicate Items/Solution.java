// Mrmoization
class Solution {
    public int solve(int[][] dp, int n, int[] val, int[] wt, int c){
        if(n == 0){
            return (c / wt[0]) * val[0];
        }
        if(dp[n][c] != -1) return dp[n][c];
        int not_take = solve(dp, n-1, val, wt, c);
        int take = 0;
        if(wt[n] <= c){
            take = val[n] + solve(dp, n, val, wt, c-wt[n]);
        }
        return dp[n][c] = Math.max(not_take, take);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, n-1, val, wt, capacity);
    }
}

// Bottom Up
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = (i / wt[0]) * val[0];
        }
        for(int i = 1; i<n; i++){
            for(int c = 0; c<=capacity; c++){
                int not_take = dp[i-1][c];
                int take = 0;
                if(wt[i]<=c){
                    take = val[i] + dp[i][c-wt[i]];
                }
                dp[i][c] = Math.max(not_take, take);
            }
        }
        return dp[n-1][capacity];
    }
}

// Space Optimization
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        int[] prev = new int[capacity+1];
        for(int i = wt[0]; i<=capacity; i++){
            prev[i] = (i/wt[0])*val[0];
        }
        for(int i = 1; i<n; i++){
            int[] curr = new int[capacity+1];
            for(int c = 0; c<=capacity; c++){
                int not_take = prev[c];
                int take = 0;
                if(wt[i]<=c){
                    take = val[i] + curr[c-wt[i]];
                }
                curr[c] = Math.max(not_take, take);
            }
            prev = curr;
        }
        return prev[capacity];
    }
}
