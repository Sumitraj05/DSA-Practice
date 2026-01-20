
// Bottom Up -> Memoization will not work here make it more complex
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}

// Space Optimization
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return ans;
    }
}
