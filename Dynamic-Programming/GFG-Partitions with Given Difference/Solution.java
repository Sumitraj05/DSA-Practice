// Bottom Up - It's Memoization and Space Optimization also possible similar to Count no. of subsets of equal sum
class Solution {
    public int countPartitions(int[] arr, int d) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Check if solution is possible
        if ((totalSum + d) % 2 != 0 || d > totalSum) return 0;

        // Calculate target sum
        int K = (totalSum + d) / 2;
        // code here
        int n = arr.length;
    
        // Create dp table with dimensions n x (K+1)
        int[][] dp = new int[n][K + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;   // {} and {0}
        } else {
            dp[0][0] = 1;   // {}
            if (arr[0] <= K)
                dp[0][arr[0]] = 1;
        }
        // Fill the table
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= K; target++) {
                // Exclude current element
                int notTake = dp[i - 1][target];

                // Include current element if possible
                int take = 0;
                if (arr[i] <= target) take = dp[i - 1][target - arr[i]];

                // Total ways
                dp[i][target] = notTake + take;
            }
        }

        // Final answer
        return dp[n - 1][K];
    }
}
