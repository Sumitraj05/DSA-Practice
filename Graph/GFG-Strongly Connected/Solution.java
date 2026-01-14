class Solution {
    // Function to find number of strongly connected components in the graph.
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, st);
            }
        }
        st.push(node);
    }
    
    public void dfs3(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs3(it, adj, vis);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        int[] vis = new int[V];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i = 0; i<V; i++){
            for(int it : adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        Arrays.fill(vis, 0);
        int scc = 0;
        while(!st.isEmpty()){
            int val = st.pop();
            if(vis[val] == 0){
                scc++;
                dfs3(val, adjT, vis);
            }
        }
        
        return scc;
    }
}
