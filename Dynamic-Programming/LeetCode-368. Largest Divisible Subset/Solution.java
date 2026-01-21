class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
                // Code here
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        int [] prev = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i<n; i++){
            prev[i] = i;
        }
        int maxInd = 0;
        int maxLen = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i]%arr[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxInd = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(prev[maxInd] != maxInd){
            ans.add(arr[maxInd]);
            maxInd = prev[maxInd];
        }
        ans.add(arr[maxInd]);
        Collections.reverse(ans);
        return ans;
    }
}
