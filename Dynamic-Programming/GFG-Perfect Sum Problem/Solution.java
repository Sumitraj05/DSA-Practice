// Memoization
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(nums.length - 1, target, nums, dp);
    }

    // Recursive helper with memoization
    private int solve(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }

        // If already computed, return from dp
        if (dp[index][target] != -1) return dp[index][target];

        // Case 1: Exclude current element
        int notTake = solve(index - 1, target, nums, dp);

        // Case 2: Include current element (if it is not greater than target)
        int take = 0;
        if (nums[index] <= target) {
            take = solve(index - 1, target - nums[index], nums, dp);
        }

        // Store result in dp and return
        return dp[index][target] = take + notTake;
    }
}

// Bottom Up
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int K) {

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

// Space Optimization
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int K) {
        int[] dp = new int[K + 1];

        if(arr[0] == 0){
            dp[0] = 2;
        }else{
            dp[0] = 1;
            if(arr[0]<=K){
                dp[arr[0]] = 1;
            }
        }

        // Loop over elements
        for (int i = 1; i < arr.length; i++) {
            // Temporary array for current iteration
            int[] curr = new int[K + 1];

            // Base case: Empty set makes sum 0
            curr[0] = 1;

            // Check all target sums
            for (int t = 0; t <= K; t++) {
                // Exclude current element
                int notTake = dp[t];

                // Include current element if possible
                int take = 0;
                if (arr[i] <= t) {
                    take = dp[t - arr[i]];
                }

                // Sum of both choices
                curr[t] = take + notTake;
            }

            // Update dp
            dp = curr;
        }

        // Return answer
        return dp[K];
    }
}
