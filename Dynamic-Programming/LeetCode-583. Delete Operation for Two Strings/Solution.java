// Bottom Up
class Solution {
    public int minDistance(String s1, String s2) {
        // Get lengths of both strings
        int n = s1.length();
        int m = s2.length();

        // Create DP table of size (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];

        // Fill the table using bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, extend LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Get LCS length
        int lcs = dp[n][m];

        // Return total operations = deletions + insertions
        return (n - lcs) + (m - lcs);
    }
}

// Space Optimization

class Solution {
    // Function to calculate minimum operations
    public int minOperations(String s1, String s2) {
        // Get lengths of both strings
        int n = s1.length(), m = s2.length();

        // Create two DP arrays
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Loop through characters of s1
        for (int i = 1; i <= n; i++) {

            // Loop through characters of s2
            for (int j = 1; j <= m; j++) {

                // If characters match, increment LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];

                // Else, take max from left or top
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }

            // Update prev with cur
            prev = cur.clone();
        }

        // Calculate total operations
        int lcs = prev[m];
        return (n - lcs) + (m - lcs);
    }
}
