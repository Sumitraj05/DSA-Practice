class Solution {
    public boolean checkPossible(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // s1 must be exactly 1 character longer
    if (n != m + 1) return false;

    int i = 0, j = 0;
    boolean skipped = false;

    while (i < n) {
        if (j < m && s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else {
            if (skipped) return false; // more than one mismatch
            skipped = true;
            i++;
        }
    }
        return true;
    }

    public int longestStrChain(String[] arr) {
        // Code here
        int n = arr.length;
        Arrays.sort(arr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(checkPossible(arr[i], arr[j]) && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
}
