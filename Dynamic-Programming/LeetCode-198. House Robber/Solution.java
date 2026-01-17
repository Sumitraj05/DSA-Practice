// Memoization
class Solution {
    int[] arr = new int[101];
    public int solve(int[] nums, int n){
        if(n >= nums.length){
            return 0;
        }
        if(arr[n] != -1){
            return arr[n];
        }
        int steal = nums[n] + solve(nums, n+2);
        int skip = solve(nums, n+1);
        arr[n] = Math.max(steal, skip);
        return arr[n];
    }
    public int rob(int[] nums) {
        for(int i = 0; i<arr.length; i++){
            arr[i] = -1;
        }
        return solve(nums, 0);
    }
}

// Bottom Up
class Solution {
     public int rob(int[] nums) {
        if(nums.length==1)  return nums[0];
        int [] dp = new int [nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1) take += dp[i-2];
            int skip = dp[i-1];
            dp[i]=Math.max(take, skip);
        }
        return dp[dp.length-1];
    }
}

// Space - Optimization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i = 1; i<n; i++){
            int take = nums[i]+prev2;
            int not_take = prev1;
            int curr = Math.max(take, not_take);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
