
// Memoization 

class Solution {
    int solve(int[] dp, int[] height, int n){
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];
        int oneStep = solve(dp, height, n-1) + Math.abs(height[n]-height[n-1]);
        int twoStep = Integer.MAX_VALUE;
        if(n > 1){
            twoStep = solve(dp, height, n-2) + Math.abs(height[n]-height[n-2]);
        }
        return dp[n] = Math.min(oneStep, twoStep);
    }
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, height, n-1);
    }

}

// Bottom-Up

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i<n; i++){
            int oneStep = dp[i-1] + Math.abs(height[i]-height[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = dp[i-2] + Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n-1];
    }
}

// Space-Optimization

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1; i<n; i++){
            int oneStep = prev1 + Math.abs(height[i]-height[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = prev2 + Math.abs(height[i]-height[i-2]);
            }
            int curr = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
