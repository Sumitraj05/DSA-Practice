class Solution {
    int timer = 1;
    public void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> bridge, List<List<Integer>> adj){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it, node, vis, tin, low, bridge, adj);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]){
                    bridge.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = connections.size();
        for(int i = 0; i<m; i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridge = new ArrayList<>();
        dfs(0, -1, vis, tin, low, bridge, adj);
        return bridge;
    }
}
