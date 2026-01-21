class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int n = prices.length;
        for(int i = 0; i<n; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
