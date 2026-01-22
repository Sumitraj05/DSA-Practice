class Solution {
    // Check if substring s[start...end] is palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // Recursive helper with memoization to find min cuts from index 'start'
    private int minCutsHelper(String s, int start, int[] memo) {
        int n = s.length();

        // If reached end or substring is palindrome, no cut needed
        if (start == n || isPalindrome(s, start, n - 1))
            return 0;

        // Return stored result if already computed
        if (memo[start] != -1)
            return memo[start];

        int minCuts = Integer.MAX_VALUE;

        // Try all possible partitions
        for (int end = start; end < n; end++) {
            if (isPalindrome(s, start, end)) {
                // 1 cut plus cuts for the remaining substring
                int cuts = 1 + minCutsHelper(s, end + 1, memo);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        // Store and return minimum cuts needed from this start
        return memo[start] = minCuts;
    }

    // Public function to get minimum cuts for palindrome partitioning
    public int minCut(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return minCutsHelper(s, 0, memo);
    }
}
