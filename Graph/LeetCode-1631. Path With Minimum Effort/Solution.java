class tuple{
    int first, second, third;
    public tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<tuple> q = new PriorityQueue<>((a, b) -> a.first - b.first);
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dist[0][0] = 0;
        q.add(new tuple(0, 0, 0));
        while(!q.isEmpty()){
            tuple t = q.poll();
            int d = t.first;
            int sr = t.second;
            int sc = t.third;
            if(d>dist[sr][sc]) continue;
            if(sr == n-1 && sc == m-1) return d;
            for(int i = 0; i<4; i++){
                int newr = sr + delrow[i];
                int newc = sc + delcol[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m){
                    int curDiff = Math.abs(grid[newr][newc]-grid[sr][sc]);
                    curDiff = Math.max(curDiff, d);
                    if(dist[newr][newc] > curDiff){
                        dist[newr][newc] = curDiff;
                        q.add(new tuple(curDiff, newr, newc));
                    }
                }
            }
        }
        return -1;
    }
}
