// User function Template for Java

class DisJointSet{
    int[] parent;
    int[] rank;
    public DisJointSet(int V){
        parent = new int[V];
        rank = new int[V];
        for(int i = 0; i<V; i++){
            parent[i] = i;
        }
    }
    
    public int findPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findPar(parent[node]);
    }
    
    public void unionByRank(int u, int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u] += 1;
        }
    }
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        DisJointSet dsu = new DisJointSet(V);
        Arrays.sort(edges, (a, b) -> a[2] -b[2]);
        int ans = 0;
        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if(dsu.findPar(u) != dsu.findPar(v)){
                ans += wt;
                dsu.unionByRank(u, v);
            }
        }
        return ans;
    }
}
