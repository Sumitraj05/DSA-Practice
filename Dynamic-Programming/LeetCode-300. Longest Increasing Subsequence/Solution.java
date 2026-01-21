// Memoization
class Solution {
    public int solve(int[][] dp, int ind, int prev, int[] nums, int n){
        if(ind == n){
            return 0;
        }
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        int not_take = solve(dp, ind+1, prev, nums, n);
        int take = 0;
        if(prev == -1 || nums[prev] < nums[ind]){
            take = 1 + solve(dp, ind+1, ind, nums, n);
        }
        return dp[ind][prev+1] = Math.max(take, not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, 0, -1, nums, n);
    }
}

// Bottom Up
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            dp[n][i] = 0;
        }
        for(int i = n-1; i>=0; i--){
            for(int j = -1; j<n; j++){
                int not_take = dp[i+1][j+1];
                int take = 0;
                if(j == -1 || nums[j] < nums[i]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take, not_take);
            }
        }
        return dp[0][0];
    }
}

// Space Optimization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i = n-1; i>=0; i--){
            for(int j = -1; j<n; j++){
                int not_take = prev[j+1];
                int take = 0;
                if(j == -1 || nums[j] < nums[i]){
                    take = 1 + prev[i+1];
                }
                curr[j+1] = Math.max(take, not_take);
            }
            prev = curr;
        }
        return prev[0];
    }
}

// Best Approch Using Binary Search - O(nlogn) TC
class Solution {
    public int lowerBound(List<Integer> temp, int target){
        int low = 0;
        int high = temp.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(temp.get(mid) >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i<n; i++){
            if(nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                int ind = lowerBound(temp, nums[i]);
                if(ind < 0) ind += 1;
                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }
}
