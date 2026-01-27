class Solution {
    public class Pair{
        int node;
        int wt;
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i = 0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, 2*w));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
        pq.add(new Pair(0, 0));
        dist[0] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            if(dist[node] < wt) continue;
            for(Pair it : adj.get(node)){
                int weight = it.wt;
                int neighbor = it.node;
                if(dist[neighbor] > wt+weight){
                    dist[neighbor] = wt+weight;
                    pq.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }
        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
    }
}
