// Using DFS Method
class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path, int[] check, int idx){
        vis[idx] = 1;
        path[idx] = 1;
        check[idx] = 0;
        
        for(int neighbour : adj.get(idx)){
            if(vis[neighbour] == 0){
                if(dfs(adj, vis, path, check, neighbour)){
                    check[idx] = 0;
                    return true;
                }
            }else if(path[neighbour] == 1){
                check[idx] = 0;
                return true;
            }
        }
        check[idx] = 1;
        path[idx] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<edges[i].length; j++){
                adj.get(i).add(edges[i][j]);
            }
        }
        int V = adj.size();
        int[] vis = new int[V];
        int[] path = new int[V];
        int[] check = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, vis, path, check, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<V; i++){
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
}

// Using BFS - TopoSort
public List<Integer> eventualSafeNodes(int V, List<Integer>[] adj) {
        List<Integer>[] adjRev = new List[V];  // Reverse adjacency list
        int[] indegree = new int[V];  // Indegree array to track nodes with no outgoing edges

        // Initialize reverse adjacency list
        for (int i = 0; i < V; i++) {
            adjRev[i] = new ArrayList<>();
        }

        // Build the reverse graph and calculate indegrees
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj[i]) {
                adjRev[neighbor].add(i);  // Reverse the direction of edges
                indegree[i]++;  // Increment indegree for the current node
            }
        }

        Queue<Integer> q = new LinkedList<>();  // Queue to store nodes with no outgoing edges
        List<Integer> safeNodes = new ArrayList<>();

        // Add all nodes with 0 indegree to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Process the queue to find all safe nodes
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);  // This node is safe
            for (int parent : adjRev[node]) {
                indegree[parent]--;  // Decrease indegree of the parent nodes
                if (indegree[parent] == 0) {
                    q.offer(parent);  // If indegree becomes 0, it is a safe node
                }
            }
        }

        Collections.sort(safeNodes);  // Sort the safe nodes
        return safeNodes;
    }
}
