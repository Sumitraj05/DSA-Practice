class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path, int[] check, int idx){
        vis[idx] = 1;
        path[idx] = 1;
        check[idx] = 0;
        
        for(int neighbour : adj.get(idx)){
            if(vis[neighbour] == 0){
                if(dfs(adj, vis, path, check, neighbour)){
                    check[idx] = 0;
                    return true;
                }
            }else if(path[neighbour] == 1){
                check[idx] = 0;
                return true;
            }
        }
        check[idx] = 1;
        path[idx] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<edges[i].length; j++){
                adj.get(i).add(edges[i][j]);
            }
        }
        int V = adj.size();
        int[] vis = new int[V];
        int[] path = new int[V];
        int[] check = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, vis, path, check, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<V; i++){
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
}
