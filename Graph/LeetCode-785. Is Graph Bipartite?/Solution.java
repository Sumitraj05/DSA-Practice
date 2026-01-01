// Using DFS
class Solution {
    public boolean dfs(int[][] graph, int[] vis, int idx, int color){
         vis[idx] = color;

         for(int neighbour : graph[idx]){
            if(vis[neighbour] == 0){
                if(!dfs(graph, vis, neighbour, 3-vis[idx])){
                    return false;
                }
            }else if(vis[neighbour] == color){
                return false;
            }
         }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] vis = new int[n];

        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                if(dfs(graph, vis, i, 1) == false) return false;;
            }
        }
        return true;
    }
}
// Using BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length;
        int m = graph[0].length;
        int[] vis = new int[n];

        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                q.add(i);
                vis[i] = 1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int j = 0; j<graph[node].length; j++){
                        int idx = graph[node][j];
                        if(vis[idx] == 0){
                            q.add(idx);
                            vis[idx] = 3-vis[node];
                        }else if(vis[idx] == vis[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
