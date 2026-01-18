class Solution {
    public int row(int[][] grid, int row, int col, int n, int m){
        int sum = 0;
        for(int i = row; i<=n; i++){
            int val = 0;
            for(int j = col; j<=m; j++){
                val += grid[i][j];
            }
            if(sum == 0){
                sum = val;
            }else if(sum != val){
                return -1;
            }
        }
        return sum;
    }

    public int col(int[][] grid, int row, int col, int n, int m){
        int sum = 0;
        for(int i = col; i<=m; i++){
            int val = 0;
            for(int j = row; j<=n; j++){
                val += grid[j][i];
            }
            if(sum == 0){
                sum = val;
            }else if(sum != val){
                return -1;
            }
        }
        return sum;
    }

    public int diagonal(int[][] grid, int row, int col, int n, int m){
        int d1 = 0;
        int d2 = 0;
        int i = row;
        int j = col;
        while(i<=n && j<=m){
            d1 += grid[i][j];
            i++;
            j++;
        }
        i = row;
        j = 0;
        while(i<=n && j<=m){
            d2 += grid[i][m-j];
            i++;
            j++;
        }
        return d1 == d2 ? d1 : -1;
    }
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int a = i;
                int b = j;
                while(a<n && b<m){
                    int row = row(grid, i, j, a, b);
                    int col = col(grid, i, j, a, b);
                    int diagonal = diagonal(grid, i, j, a, b);
                    if(row != -1 && col != -1 && diagonal != -1){
                        if(row == col && col == diagonal){
                            max = Math.max(max, a-i+1);
                        }
                    }
                    a++;
                    b++;
                }
            }
        }
        return max;
    }
}
