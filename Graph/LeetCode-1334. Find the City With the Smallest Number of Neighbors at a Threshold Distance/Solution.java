class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] arr : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int e = edges.length;
        for(int i = 0; i<e; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for(int i = 0; i<n; i++) dist[i][i] = 0;
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int cityNo = -1;
        int cntCity = n;
        for(int city = 0; city<n; city++){
            int cnt = 0;
            for(int i = 0; i<n; i++){
                if(dist[city][i] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
