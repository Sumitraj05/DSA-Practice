// Memoization
class Solution {
    private int countWaysToMakeChangeUtil(int[] arr, int ind, int T, int[][] dp) {
        if (ind == 0) {
            return (T % arr[0] == 0) ? 1 : 0;
        }
        if (dp[ind][T] != -1) return dp[ind][T];

        int notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);
        int taken = 0;
        if (arr[ind] <= T) {
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);
        }
        return dp[ind][T] = notTaken + taken;
    }
    public int change(int amount, int[] arr) {
        int n = arr.length;
        int T = amount;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }
}

// Bottom Up
class Solution{
    public int change(int T, int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][T];
    }
}

// Space Optimization
// Bottom Up
class Solution{
    public int change(int T, int[] arr){
        int n = arr.length;
        int[] prev = new int[T+1];

        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[T+1];
            for (int target = 0; target <= T; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (arr[ind] <= target)
                    taken = curr[target-arr[ind]];

                curr[target] = taken + notTaken;
            }
            prev = curr;
        }

        return prev[T];
    }
}
