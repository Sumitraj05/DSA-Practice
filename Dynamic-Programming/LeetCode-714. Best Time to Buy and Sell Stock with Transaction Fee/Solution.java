// Memoization
class Solution {
    public int solve(int[][] dp, int[] prices, int ind, int buy, int n, int fee){
        if(ind == n){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[ind] + solve(dp, prices, ind+1, 1, n, fee), 0 + solve(dp, prices, ind+1, 0, n, fee));
        }else{
            profit = Math.max(prices[ind]-fee + solve(dp, prices, ind+1, 0, n, fee), 0 + solve(dp, prices, ind+1, 1, n, fee));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, prices, 0, 0, n, fee);
    }
}

// Bottom Up
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][1] = dp[n][0] = 0;
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                if(j == 0){
                    dp[i][j] = Math.max(-prices[i] + dp[i+1][1], 0 + dp[i+1][0]);
                }else{
                    dp[i][j] = Math.max(prices[i]-fee + dp[i+1][0], 0 + dp[i+1][1]);
                }
            }
        }
        return dp[0][0];
    }
}

// Space Optimizaion
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0] = prev[1] = 0;
        int[] curr = new int[2];
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                if(j == 0){
                    curr[j] = Math.max(-prices[i] + prev[1], 0 + prev[0]);
                }else{
                    curr[j] = Math.max(prices[i]-fee + prev[0], 0 + prev[1]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
}
