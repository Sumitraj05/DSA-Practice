class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int[] vis = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dest = new int[V];
        Arrays.fill(dest, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = 1;
        dest[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(vis[it] == 0 && dest[node] + 1 < dest[it]){
                    dest[it] = dest[node]+1;
                    q.add(it);
                    vis[it] = 1;
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
