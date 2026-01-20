// // Memoization
class Solution {
    public int solve(int[][] dp, String text1, String text2, int n, int m){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        if(text1.charAt(n) == text2.charAt(m)){
            return dp[n][m] = 1 + solve(dp, text1, text2, n-1, m-1);
        }
        return dp[n][m] =  Math.max(solve(dp, text1, text2, n-1, m), solve(dp, text1, text2, n, m-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, text1, text2, n-1, m-1);
    }
}

// Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<m+1; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

// Space Optimization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        for(int i = 1; i<n+1; i++){
            int[] cur = new int[m+1];
            for(int j = 1; j<m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }
        return prev[m];
    }
}
