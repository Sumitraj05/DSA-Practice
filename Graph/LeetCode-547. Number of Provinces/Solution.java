class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] vis){
        vis[i] = 1;
        for(int idx : adj.get(i)){
            if(vis[idx] == 0){
                dfs(adj, idx, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = isConnected.length;
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int ans = 0;
        int[] vis = new int[V];
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(adj, i, vis);
                ans++;
            }
        }
        return ans;
    }
}
