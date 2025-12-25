class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        int d = 0;
        for(int i = n-1; i>=0; i--){
            int val = happiness[i]-d;
            if(k <= 0 || val <= 0) break;
            ans += val;
            k--;
            d++;
        }
        return ans;
    }
}
