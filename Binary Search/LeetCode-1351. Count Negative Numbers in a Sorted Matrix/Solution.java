class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int i = n-1;
        int j = 0;
        while(i>=0 && j<m){
            if(grid[i][j] < 0){
                cnt += m-j;
                i--;
            }else{
                j++;
            }
        }
        return cnt;
    }
}
