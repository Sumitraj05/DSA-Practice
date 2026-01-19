// Memoization
class Solution {
    static Boolean solve(Boolean[][]dp, int[] arr, int target, int n, int idx){
        if(target == 0){
            return true;
        }
        if(idx == n){
            return arr[idx] == target;
        }
        if(dp[idx][target] != null) return dp[idx][target];
        Boolean not_taken = solve(dp, arr, target, n, idx+1);
        Boolean taken = false;
        if(arr[idx] <= target){
            taken = solve(dp, arr, target-arr[idx], n, idx+1);
        }
        return dp[idx][target] =  taken || not_taken;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return solve(dp, arr, sum, arr.length-1, 0);
    }
}

// Bottom Up
class Solution {
    // Function to check if subset with sum k exists in arr
    public boolean subsetSumToK(int n, int k, int[] arr) {
        // Create DP table with n rows and k+1 columns, default false
        boolean[][] dp = new boolean[n][k + 1];

        // Base case: sum=0 can always be formed by empty subset
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: If first element <= k, mark dp[0][arr[0]] true
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table iteratively
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Option 1: Do not take the current element
                boolean notTaken = dp[ind - 1][target];

                // Option 2: Take current element if it does not exceed target
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Mark current cell as true if either option is true
                dp[ind][target] = notTaken || taken;
            }
        }

        // Return whether sum k can be formed using all elements
        return dp[n - 1][k];
    }
}

// Space Optimization
class Solution {
    // Function to check if subset with sum k exists using space optimized DP
    public boolean subsetSumToK(int n, int k, int[] arr) {
        // Initialize previous row of DP table with false
        boolean[] prev = new boolean[k + 1];

        // Base case: sum 0 can always be formed with empty subset
        prev[0] = true;

        // Base case: if first element <= k, mark true
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Iterate over elements starting from second
        for (int ind = 1; ind < n; ind++) {
            // Current row of DP table
            boolean[] cur = new boolean[k + 1];
            cur[0] = true; // sum 0 always possible

            for (int target = 1; target <= k; target++) {
                // Option 1: not take current element
                boolean notTaken = prev[target];

                // Option 2: take current element if possible
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // Store true if either option is true
                cur[target] = notTaken || taken;
            }
            // Move current row to previous for next iteration
            prev = cur;
        }

        // Return if sum k is possible using all elements
        return prev[k];
    }
}
