// Using DFS Method
class Solution {
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i = 0 ; i<n; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int[] vis = new int[V];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, stack, vis, i);
            }
        }
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] vis, int node){
        vis[node] = 1;
        for(int neighbour : adj.get(node)){
            if(vis[neighbour] == 0){
                dfs(adj, stack, vis, neighbour);
            }
        }
        stack.push(node);
    }
}

// Using Kahn's Algorithm - BFS
class Solution {
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
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
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}
