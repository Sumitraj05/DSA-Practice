// Memoization
class Solution {
    int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0 profit
        if (ind == n || cap == 0)
            return 0;

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 0, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 1, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }

    int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][k+1];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns(prices, n, 0, 0, k, dp);
    }
}

// Bottom Up
class Solution {
    int maxProfit(int k, int[] prices) {
        // DP table: dp[ind][buy][cap]
        // ind → current index
        // buy → 0 = can buy, 1 = can sell
        // cap → remaining transactions (max 2)
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+2];

        // Base case: initialized to 0 → no profit if no transactions left or no days left

        // Fill DP table from the last day to the first
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) { // cap starts from 1 because 0 means no transactions left
                    if (buy == 0) {
                        // Option 1: skip buying
                        // Option 2: buy today → subtract price, keep cap same
                        dp[ind][buy][cap] = Math.max(
                            0 + dp[ind + 1][0][cap],
                            -prices[ind] + dp[ind + 1][1][cap]
                        );
                    } else {
                        // Option 1: skip selling
                        // Option 2: sell today → add price, reduce cap by 1
                        dp[ind][buy][cap] = Math.max(
                            0 + dp[ind + 1][1][cap],
                            prices[ind] + dp[ind + 1][0][cap - 1]
                        );
                    }
                }
            }
        }

        // Final result: start at index 0, can buy, with 2 transactions left
        return dp[0][0][k];
    }
}

// Space Optimization
class Solution {
    int maxProfit(int k, int[] prices) {
        // DP table: dp[ind][buy][cap]
        // ind → current index
        // buy → 0 = can buy, 1 = can sell
        // cap → remaining transactions (max 2)
        int n = prices.length;
        // 'ahead' stores future state, 'cur' stores current state
        int[][] ahead = new int[2][k+2];
        int[][] cur = new int[2][k+2];

        // Iterate from the last day to the first day (reverse order)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) { // 0 = buy possible, 1 = sell possible
                for (int cap = 1; cap <= k; cap++) { // At most 2 transactions
                    if (buy == 0) {
                        // Option 1: Skip buying, Option 2: Buy stock
                        cur[buy][cap] = Math.max(ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    } else {
                        // Option 1: Skip selling, Option 2: Sell stock
                        cur[buy][cap] = Math.max(ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            // Move current state to ahead for the next iteration
            for (int i = 0; i < 2; i++) {
                System.arraycopy(cur[i], 0, ahead[i], 0, k+2);
            }
        }

        return ahead[0][k]; // Maximum profit starting at day 0 with 2 transactions
    }
}
