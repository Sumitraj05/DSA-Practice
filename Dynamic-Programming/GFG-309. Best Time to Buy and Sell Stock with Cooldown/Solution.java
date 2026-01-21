// Memoization
class Solution {
    public int solve(int[][] dp, int[] prices, int ind, int buy, int n){
        if(ind >= n){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[ind] + solve(dp, prices, ind+1, 1, n), 0 + solve(dp, prices, ind+1, 0, n));
        }else{
            profit = Math.max(prices[ind] + solve(dp, prices, ind+2, 0, n), 0 + solve(dp, prices, ind+1, 1, n));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, prices, 0, 0, n);
    }
}

// Bottom Up
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n][1] = dp[n][0] = 0;
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                if(j == 0){
                    dp[i][j] = Math.max(-prices[i] + dp[i+1][1], 0 + dp[i+1][0]);
                }else{
                    dp[i][j] = Math.max(prices[i] + dp[i+2][0], 0 + dp[i+1][1]);
                }
            }
        }
        return dp[0][0];
    }
}

// Space Optimizaion
class Solution {
    public int maxProfit(int[] Arr) {
        int n = Arr.length;
        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        
        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + front1[0], -Arr[ind] + front1[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + front1[1], Arr[ind] + front2[0]);
                }

                cur[buy] = profit;
            }

            // Update front1 and front2 arrays
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }

        // The maximum profit is stored in cur[0]
        return cur[0];
    }
}
