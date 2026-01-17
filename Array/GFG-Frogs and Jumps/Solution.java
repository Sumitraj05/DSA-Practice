// User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        Arrays.sort(frogs);
        boolean[] visited = new boolean[leaves+1];
        int cnt = leaves;
        for(int i = 0; i<N; i++){
            int frog_st = frogs[i];
            if(frog_st == 1){
                return 0;
            }
            if(frog_st > leaves) continue;
            if(visited[frog_st]) continue;
            
            for(int j = frog_st; j<=leaves; j += frog_st){
                if(!visited[j]){
                    cnt--;
                }
                visited[j] = true;
            }
        }
        return cnt;
    }
}
