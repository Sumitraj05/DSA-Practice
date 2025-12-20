class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for(int i = 0; i<=k; i++){
            ans += Math.min(tickets[i], tickets[k]);
        }
        int n = tickets.length;
        for(int i = k+1; i<n; i++){
            ans += Math.min(tickets[i], tickets[k]-1);
        }
        
        return ans;
    }
}
