class tuple{
    int first, second, third;
    public tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int[][] dist = new int[n][n];
        int[] delrow = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] delcol = {0, 1, 0, -1, 1, 1, -1, -1};
        dist[0][0] = 1;
        q.add(new tuple(1, 0, 0));
        while(!q.isEmpty()){
            tuple t = q.poll();
            int d = t.first;
            int sr = t.second;
            int sc = t.third;
            if(sr == n-1 && sc == n-1) return d;
            for(int i = 0; i<8; i++){
                int newr = sr + delrow[i];
                int newc = sc + delcol[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 0 && dist[newr][newc] == 0){
                    dist[newr][newc] = 1;
                    q.add(new tuple(d+1, newr, newc));
                }
            }
        }
        return -1;
    }
}
