class Solution {
    public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int countPaths(int V, int[][] edges) {
        // code here
        final int MOD = 1000000007;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        int[] dist = new int[V];
        int[] ways = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int d = top.first;
            int u = top.second;
            if (d > dist[u]) continue;
            for (Pair nxt : adj.get(u)) {
                int v = nxt.first;
                int w = nxt.second;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.add(new Pair(dist[v], v));
                }
                else if (dist[v] == dist[u] + w) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[V - 1] % MOD;
    }
}
