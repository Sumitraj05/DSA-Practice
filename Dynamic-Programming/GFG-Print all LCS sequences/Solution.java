class Solution {

    Map<String, Set<String>> memo = new HashMap<>();

    public List<String> allLCS(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // Build LCS length DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Set<String> result = backtrack(s, t, n, m, dp);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> backtrack(String s, String t, int n, int m, int[][] dp) {
        String key = n + "#" + m;
        if (memo.containsKey(key)) return memo.get(key);

        Set<String> res = new HashSet<>();

        if (n == 0 || m == 0) {
            res.add("");
            memo.put(key, res);
            return res;
        }

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            Set<String> temp = backtrack(s, t, n - 1, m - 1, dp);
            for (String str : temp) {
                res.add(str + s.charAt(n - 1));
            }
        } else {
            if (dp[n - 1][m] == dp[n][m]) {
                res.addAll(backtrack(s, t, n - 1, m, dp));
            }
            if (dp[n][m - 1] == dp[n][m]) {
                res.addAll(backtrack(s, t, n, m - 1, dp));
            }
        }

        memo.put(key, res);
        return res;
    }
}
