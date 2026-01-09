class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int _first, int _second){
            first = _first;
            second = _second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        int m = times.length;
        for(int i = 0; i<m; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(0, k));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int wt = p.first;
            int u = p.second;
            if(wt > dist[u]) continue;
            for(Pair it : adj.get(u)){
                int v = it.first;
                int d = it.second;
                if(d+wt < dist[v]){
                    dist[v] = d+wt;
                    pq.add(new Pair(d+wt, v));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
