// Memoization
class Solution {
    private boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base case: target sum reached
        if (target == 0)
            return true;

        // Base case: first element check
        if (ind == 0)
            return arr[0] == target;

        // If already computed, return stored result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        // Choice 1: exclude current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Choice 2: include current element if possible
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Store result in dp table
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        int n = nums.length;
        int[][] dp = new int[n][targetSum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Check possibility using recursion + memoization
        return subsetSumUtil(n - 1, targetSum, nums, dp);
    }
}


// Bottom Up
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][targetSum+1];
        for(int i = 0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= targetSum){
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<=targetSum; j++){
                boolean not_taken = dp[i-1][j];
                boolean taken = false;
                if(nums[i] <= j){
                    taken = dp[i-1][j-nums[i]];
                }
                dp[i][j] = taken || not_taken;
            }
        }
        return dp[n-1][targetSum];
    }
}

// Space optimized
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        int n = nums.length;
        boolean[] prev = new boolean[targetSum+1];
        prev[0] = true;
        if(nums[0] <= targetSum) prev[nums[0]] = true;
        for(int i = 1; i<n; i++){
            boolean[] curr = new boolean[targetSum+1];
            curr[0] = true;
            for(int target = 1; target<=targetSum; target++){
                boolean not_taken = prev[target];
                boolean taken = false;
                if(nums[i]<=target){
                    taken = prev[target-nums[i]];
                }
                curr[target] = not_taken || taken;
            }
            prev = curr;
        }
        return prev[targetSum];
    }
}
