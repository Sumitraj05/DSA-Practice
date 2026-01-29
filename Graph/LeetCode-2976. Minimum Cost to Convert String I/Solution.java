class Solution {
    public class Pair{
        int node;
        int wt;
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        int n = original.length;
        for(int i = 0; i<n; i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            int w = cost[i];
            adj.get(u).add(new Pair(v, w));
        }
        int[][] dist = new int[26][26];
        for(int i = 0; i<26; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dijkstra(adj, i, dist[i]);
        }
        long min = 0;
        int m = source.length();
        for(int i = 0; i<m; i++){
                int u = source.charAt(i)-'a';
                int v = target.charAt(i)-'a';
            if(u != v){
                if(dist[u][v] == Integer.MAX_VALUE) return -1;
                min += dist[u][v];
            }
        }
        return min;
    }
    public void dijkstra(ArrayList<ArrayList<Pair>> adj, int src, int[] dist){
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
        q.add(new Pair(src, 0));
        dist[src] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int wt = p.wt;
            if(wt > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int neighbor = it.node;
                int w = it.wt;
                if(dist[neighbor] > wt+w){
                    dist[neighbor] = wt+w;
                    q.add(new Pair(neighbor, wt+w));
                }
            }
        }
    }
}
