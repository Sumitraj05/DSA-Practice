class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int[] ans = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0 ; i<n; i++){
            adj.get(edges[i][1]).add(edges[i][0]);
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
        int i = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            cnt++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return cnt == V ? ans : new int[0];
    }
}
