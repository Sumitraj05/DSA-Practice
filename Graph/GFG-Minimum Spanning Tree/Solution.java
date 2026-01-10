class Solution {
    public class Pair{
        int node;
        int distance;
        public Pair(int _node, int _distance){
            node = _node;
            distance = _distance;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Pair>());
        }
        int n = edges.length;
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        int[] vis = new int[V];
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int w = p.distance;
            if(vis[u] == 1) continue;
            sum += w;
            vis[u] = 1;
            for(Pair it : adj.get(u)){
                int v = it.node;
                int dist = it.distance;
                if(vis[v] == 0){
                    pq.add(new Pair(v, dist));
                }
            }
        }
        return sum;
    }
}
