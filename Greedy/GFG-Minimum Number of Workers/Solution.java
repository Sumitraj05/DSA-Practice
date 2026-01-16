import java.util.*;

class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        // 1. Create valid intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                // Ensure we don't go out of bounds if the problem restricts it, 
                // though usually i-arr[i] is fine.
                intervals.add(new int[]{i - arr[i], i + arr[i]});
            }
        }

        // 2. Sort by start point ascending
        Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int currentEnd = 0; // The rightmost point we've covered
        int i = 0;
        int numIntervals = intervals.size();

        // 3. Greedy coverage
        while (currentEnd < n) {
            int maxReach = -1;

            // Find the interval that starts within covered range but reaches furthest
            while (i < numIntervals && intervals.get(i)[0] <= currentEnd) {
                maxReach = Math.max(maxReach, intervals.get(i)[1]);
                i++;
            }

            // If we can't extend anymore and haven't reached the end
            if (maxReach < currentEnd || maxReach == -1) {
                return -1; 
            }

            count++;
            currentEnd = maxReach + 1; // Move to the next point to cover

            if (currentEnd >= n) return count;
        }

        return count;
    }
}
