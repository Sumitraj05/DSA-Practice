class Solution {

    // Function to calculate Longest Common Subsequence
    public int lcs(String s1, String s2) {

        // Get sizes of strings
        int n = s1.length();
        int m = s2.length();

        // Create dp array
        int[][] dp = new int[n + 1][m + 1];

        // Fill dp array
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                // If characters match
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 
                        1 + dp[ind1 - 1][ind2 - 1];
                }

                // If they don't match
                else {
                    dp[ind1][ind2] = 
                        Math.max(dp[ind1 - 1][ind2], 
                                 dp[ind1][ind2 - 1]);
                }
            }
        }

        // Return bottom-right value
        return dp[n][m];
    }

    // Function to calculate LPS
    public int longestPalindromeSubsequence(String s) {
        
        // Reverse string
        String t = new StringBuilder(s).reverse().toString();

        // LCS of s and reverse
        return lcs(s, t);
    }

    // Function to calculate minimum insertions
    public int minInsertion(String s) {

        // Get length
        int n = s.length();

        // Get LPS length
        int k = longestPalindromeSubsequence(s);

        // Return answer
        return n - k;
    }
}

// Another Way - Memoization Using iterating on same string
class Solution {
    public int solve(int[][] dp, String s, int i, int j){
        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = 1 + solve(dp, s, i+1, j);
        int left = 1 + solve(dp, s, i, j-1);
        return dp[i][j] = Math.min(left, right);
    }
    public int minInsertions(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        int[][] dp = new int[501][501];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(dp, s, i, j);
    }
}
