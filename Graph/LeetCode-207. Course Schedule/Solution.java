class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0 ; i<n; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        
        int[] indegree = new int[V];
        for(int i = 0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return cnt == V;
    }
}
