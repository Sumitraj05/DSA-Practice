class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int orange = grid[i][j];
                if(orange != 0){
                    total++;
                    if(orange == 2){
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int days = 0;
        while(!q.isEmpty()){
            int k = q.size();
            count += k;
            for(int j = 0; j<k; j++){
                int[] rotten = q.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int i = 0; i<4; i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m && grid[nrow][ncol] == 1){
                        q.add(new int[]{nrow, ncol});
                        grid[nrow][ncol] = 2;
                    }
                }
            }
            if(!q.isEmpty()) days++;
        }
        return total == count ? days : -1;

    }
}
