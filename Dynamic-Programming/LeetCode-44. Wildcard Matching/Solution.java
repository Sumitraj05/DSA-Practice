// Memoization
class Solution {
    public boolean solve(int[][] dp, String s, String p, int i, int j){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int k = 0; k<=j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = solve(dp, s, p, i-1, j-1) ? 1 : 0;
        }
        else if(p.charAt(j) == '*'){
            dp[i][j] = (solve(dp, s, p, i-1, j) || solve(dp, s, p, i, j-1)) ? 1 : 0;
        }else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return solve(dp, s, p, n-1, m-1);
    }
}

// // Bottom Up
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty string & empty pattern
        dp[0][0] = true;

        // Empty string vs pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {

                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {

                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}

// Space Optimization
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] dp = new boolean[m + 1];

        // Base case: empty string & empty pattern
        dp[0] = true;

        // Empty string vs pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            } else {
                dp[j] = false;
            }
        }

        // Fill DP row by row
        for (int i = 1; i <= n; i++) {

            boolean prev = dp[0]; // dp[i-1][0]
            dp[0] = false;        // non-empty string can't match empty pattern

            for (int j = 1; j <= m; j++) {

                boolean temp = dp[j]; // store old dp[i-1][j]

                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {

                    dp[j] = prev;

                } else if (p.charAt(j - 1) == '*') {

                    dp[j] = dp[j] || dp[j - 1];

                } else {
                    dp[j] = false;
                }

                prev = temp; // move diagonal
            }
        }

        return dp[m];
    }
}
