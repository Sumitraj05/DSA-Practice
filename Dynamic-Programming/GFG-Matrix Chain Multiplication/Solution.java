// Memoization
class Solution {
    static int solve(int[][] dp, int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int cost1 = solve(dp, arr, i, k);
            int cost2 = solve(dp, arr, k+1, j);
            int operations = arr[i-1]*arr[k]*arr[j];
            int total = cost1 + cost2 + operations;
            minCost = Math.min(minCost, total);
        }
        return dp[i][j] = minCost;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, arr, 1, n-1);
    }
}

// Bottom Up
class Solution {
    static int matrixMultiplication(int nums[]) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Initialize the dp array with large values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // A single matrix doesn't require any multiplication
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Filling the dp array in a bottom-up manner
        for (int length = 2; length < n; length++) {
            for (int i = 1; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    // Calculate cost
                    int cost = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    // Take the minimum cost
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // The result is in dp[1][n-1] (multiplying from matrix 1 to n-1)
        return dp[1][n - 1];
    }
}
