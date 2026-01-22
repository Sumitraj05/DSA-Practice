class Solution {
    // Recursive helper function to find max sum from 'start' index
    private int helper(int[] arr, int k, int start, int[] memo) {
        int n = arr.length;

        // Base case: if start reached end, no elements left to partition
        if (start == n) return 0;

        // Return cached result if already computed for this start index
        if (memo[start] != -1) return memo[start];

        int maxSum = 0;    
        int maxElem = 0;   

        // Try partitions of length 1 to k starting at 'start'
        for (int length = 1; length <= k && start + length <= n; length++) {
            // Update max element for this partition length
            maxElem = Math.max(maxElem, arr[start + length - 1]);

            // Calculate current sum: maxElem * length + recursive result for remaining array
            int currentSum = maxElem * length + helper(arr, k, start + length, memo);

            // Update maxSum if current partition leads to higher sum
            maxSum = Math.max(maxSum, currentSum);
        }

        // Memoize and return the best max sum for this start index
        return memo[start] = maxSum;
    }

    // Public method to start the recursion with memoization
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        // Initialize memo array with -1 to indicate unvisited states
        int[] memo = new int[n];
        java.util.Arrays.fill(memo, -1);

        // Start recursion from index 0
        return helper(arr, k, 0, memo);
    }
}
