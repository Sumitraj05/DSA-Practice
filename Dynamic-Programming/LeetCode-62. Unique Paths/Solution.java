// Memoization

// class Solution {
//     public int solve(int[][] dp, int i, int j){
//         if(i == 0 && j == 0) return 1;
//         if(i < 0 || j<0) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         int up = solve(dp, i-1, j);
//         int left = solve(dp, i, j-1);
//         return dp[i][j] = up + left;
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int[] arr : dp){
//             Arrays.fill(arr, -1);
//         }
//         return solve(dp, m-1, n-1);
//     }
// }

// Bottom up

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         dp[0][0] = 1;
//         for(int i = 0; i<m; i++){
//             for(int j = 0; j<n; j++){
//                 if(i == 0 && j == 0){
//                     dp[0][0] = 1;
//                     continue;  
//                 } 
//                 int down = 0;
//                 int right = 0;
//                 if(i > 0){
//                     down = dp[i-1][j];
//                 }
//                 if(j > 0){
//                     right = dp[i][j-1];
//                 }
//                 dp[i][j] = right+down;
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

// Space Optimization

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[] prev = new int[n];
//         for(int i = 0; i<m; i++){
//             int[] temp = new int[n];
//             for(int j = 0; j<n; j++){
//                 if(i == 0 && j == 0){
//                     temp[j] = 1;
//                     continue;  
//                 } 
//                 int down = 0;
//                 int right = 0;
//                 if(i > 0){
//                     down = prev[j];
//                 }
//                 if(j > 0){
//                     right = temp[j-1];
//                 }
//                 temp[j] = right+down;
//             }
//             prev = temp;
//         }
//         return prev[n-1];
//     }
// }
