class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path, int idx){
        vis[idx] = 1;
        path[idx] = 1;
        
        for(int neighbour : adj.get(idx)){
            if(vis[neighbour] == 0){
                if(dfs(adj, vis, path, neighbour)) return true;
            }else if(path[neighbour] == 1){
                return true;
            }
        }
        path[idx] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        int[] vis = new int[V];
        int[] path = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, path, i)) return true;
            }
        }
        return false;
    }
}
