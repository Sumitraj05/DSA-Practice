// Using BFS
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                vis[i] = true;
                q.add(new int[]{i, -1});
                while(!q.isEmpty()){
                    int[] a = q.poll();
                    int node = a[0];
                    int parent = a[1];
                    for(int idx : adj.get(node)){
                        if(!vis[idx]){
                            vis[idx] = true;
                            q.add(new int[]{idx, node});
                        }else if(idx != parent){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


// Using DFS
class Solution {
    
    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                if(dfs(i, node, adj, vis)) return true;
            }
            else if(i != parent) return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}
