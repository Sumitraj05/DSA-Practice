// Memoization
class Solution {
    public int solve(int[][] dp, List<List<Integer>> triangle, int i, int j, int n){
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int same_index = triangle.get(i).get(j) + solve(dp, triangle, i+1, j, n);
        int next_index = triangle.get(i).get(j) + solve(dp, triangle, i+1, j+1, n);
        return dp[i][j] = Math.min(same_index, next_index);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return solve(dp, triangle, 0, 0, n);
    }
}

// Bottom Up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int j = 0; j<m; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i>=0; i--){
            for(int j = i; j>=0; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}

// Space Optimization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[] prev = new int[m];
        for(int j = 0; j<m; j++){
            prev[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i>=0; i--){
            int[] temp = new int[m];
            for(int j = i; j>=0; j--){
                int down = triangle.get(i).get(j) + prev[j];
                int diag = triangle.get(i).get(j) + prev[j+1];
                temp[j] = Math.min(down, diag);
            }
            prev = temp;
        }
        return prev[0];
    }
}
