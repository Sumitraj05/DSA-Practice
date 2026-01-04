class Solution {
    public class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer> ans = new ArrayList<>();
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;
        pq.offer(new Pair(1, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int d = p.dist;
            if(d > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int curr = it.node;
                int wt = it.dist;
                if(d+wt < dist[curr]){
                    dist[curr] = d+wt;
                    pq.offer(new Pair(curr, d+wt));
                    parent[curr] = node;
                }
            }
        }
        if(dist[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        } 
        int len = n;
        while(parent[len] != len){
            ans.add(len);
            len = parent[len];
        }
        ans.add(1);
        ans.add(dist[n]);
        Collections.reverse(ans);
        return ans;
    }
}
