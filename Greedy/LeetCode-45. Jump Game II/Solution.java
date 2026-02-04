// Memoization - But is giving TLE
// class Solution {
//     public int solve(int[][] dp, int idx, int jumps, int[] nums, int n){
//         if(idx >= n) return jumps;
//         if(dp[idx][jumps] != -1) return dp[idx][jumps];
//         int max = Integer.MAX_VALUE;
//         for(int i = 1; i<=nums[idx]; i++){
//             max = Math.min(max, solve(dp, idx+i, jumps+1, nums, n));
//         }
//         return dp[idx][jumps] = max;
//     }
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for(int[] arr : dp){
//             Arrays.fill(arr, -1);
//         }
//         return solve(dp, 0, 0, nums, n-1);
//     }
// }

// O(n) - Solution
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int curr = 0;
        int jumps = 0;
        for(int i = 0; i<n-1; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(curr == i){
                jumps++;
                curr = farthest;
            }
        }
        return jumps;
    }
}
