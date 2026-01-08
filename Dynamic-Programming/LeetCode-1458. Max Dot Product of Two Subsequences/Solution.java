class Solution {
    int n;
    int m;
    public int solve(int[] nums1, int[] nums2, int[][] dp, int i, int j){
        if(i >= n || j>=m){
            return -10000001;
        }
        if(dp[i][j] != -10000001){
            return dp[i][j];
        }
        int val = nums1[i]*nums2[j];
        int take_i_j = (nums1[i]*nums2[j]) + solve(nums1, nums2, dp, i+1, j+1);
        int take_i = solve(nums1, nums2, dp, i, j+1);
        int take_j = solve(nums1, nums2, dp, i+1, j);
        return dp[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i, take_j)));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        int[][] dp = new int[501][501];
        for(int[] arr : dp){
            Arrays.fill(arr, -10000001);
        }
        return solve(nums1, nums2, dp, 0, 0);
    }
}
