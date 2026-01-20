// Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        // Creating dp array initialized with -2
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);

        // Calling helper function
        return helper(coins, amount, dp);
    }

    // Helper recursive function
    private int helper(int[] coins, int rem, int[] dp) {
        // If remaining amount is zero
        if (rem == 0) return 0;

        // If remaining amount is negative
        if (rem < 0) return -1;

        // If already computed
        if (dp[rem] != -2) return dp[rem];

        // Initialize minimum with large value
        int mini = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            // Recursive call
            int res = helper(coins, rem - coin, dp);

            // If result is valid
            if (res >= 0 && res < mini)
                mini = 1 + res;
        }

        // Store result in dp
        dp[rem] = (mini == Integer.MAX_VALUE) ? -1 : mini;
        return dp[rem];
    }
}

// Bottom Up
class Solution {
    // Function to find minimum coins
    public int coinChange(int[] coins, int amount) {
        // Creating dp array of size amount+1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: dp[0] = 0
        dp[0] = 0;

        // Loop through all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin
            for (int coin : coins) {
                // If coin can be used
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    // Update dp[i] with minimum coins
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] is still infinity, return -1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
