// NOTE - You can solve this question using Longest Common Subsequence Solution alsow 
// just you have to create a reverse of the string and then find the LCS of both strings.

// Memoization
class Solution {
    int[][] t;
    public int solve(String s , int i, int j){
        if(j<i){
            return 0;
        }
        if(i == j){
            return 1;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = 2+solve(s, i+1, j-1);
        }
        return t[i][j] = Math.max(solve(s, i+1, j), solve(s, i, j-1));

    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n][n];
        for(int[] row: t){
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n-1);
    }
}

// Bottom Up
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] t = new int[n][n];
        for(int i = 0; i<n; i++){
            t[i][i] = 1;
        }
        for(int L = 2; L<=n; L++){
            for(int i = 0; i<n-L+1; i++){
                int j = i+L-1;
                if(s.charAt(i) == s.charAt(j) && L==2){
                    t[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    t[i][j] = 2+t[i+1][j-1];
                }else{
                    t[i][j] = Math.max(t[i+1][j], t[i][j-1]);
                }
            }
        }
        return t[0][n-1];
    }
}
