class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] prefA = new long[n + 1];
        long[] prefP = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefA[i + 1] = prefA[i] + (long) strategy[i] * prices[i];
            prefP[i + 1] = prefP[i] + prices[i];
        }

        long base = prefA[n];
        long bestGain = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int r = l + k - 1;

            long old = prefA[r + 1] - prefA[l];
            long newer = prefP[r + 1] - prefP[l + half];

            long gain = newer - old;
            bestGain = Math.max(bestGain, gain);
        }

        return base + bestGain;
    }
}
