class tuple{
    int first, second, third;
    public tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Pair{
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> ans = new ArrayList<>();
        Queue<tuple> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            ans.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            ans.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new tuple(0, src, 0));
        while(!q.isEmpty()){
            tuple t = q.poll();
            int steps = t.first;
            int sc = t.second;
            int d = t.third;
            if(steps > k) continue;
            for(Pair it : ans.get(sc)){
                int des = it.first;
                int wt = it.second;
                if(steps <= k && d+wt < dist[des]){
                    dist[des] = d+wt;
                    q.add(new tuple(steps+1, des, d+wt));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
