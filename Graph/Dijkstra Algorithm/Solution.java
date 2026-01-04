class Solution {
    public class Pair{
        int dist;
        int node;
        public Pair(int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(0, src));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int d = pq.peek().dist;
            pq.remove();
            for(Pair it : adj.get(node)){
                int neighbour = it.node;
                int w = it.dist;
                if(d+w < dist[neighbour]){
                    dist[neighbour] = d+w;
                    pq.offer(new Pair(d+w, neighbour));
                }
            }
        }
        return dist;
    }
}
