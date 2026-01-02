// User function Template for Java
class Solution {
    public class Pair{
        int dest;
        int wt;
        public Pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }
    public void dfs(ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack, int[] vis, int node){
        vis[node] = 1;
        for(Pair it : adj.get(node)){
            int neighbour = it.dest;
            if(vis[neighbour] == 0){
                dfs(adj, stack, vis, neighbour);
            }
        }
        stack.push(node);
    }
    
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i = 0; i<E; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            adj.get(src).add(new Pair(dest, wt));
        }
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, stack, vis, i);
            }
        }
        int[] dest = new int[V];
        Arrays.fill(dest, Integer.MAX_VALUE);
        dest[0] = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(dest[node] != Integer.MAX_VALUE){
                for(Pair it : adj.get(node)){
                    int neighbour = it.dest;
                    int wt = it.wt;
                    if(dest[node] + wt < dest[neighbour]){
                        dest[neighbour] = dest[node]+wt;
                    }
                }
            }
        }
        for(int i = 0; i<V; i++){
            if(dest[i] == Integer.MAX_VALUE){
                dest[i] = -1;
            }
        }
        return dest;
    }
}
