import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Step 1: Sort the bars to find consecutive sequences
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // Step 2: Find the max consecutive sequence in both directions
        int maxH = getMaxConsecutive(hBars);
        int maxV = getMaxConsecutive(vBars);

        // Step 3: The side of the square is the minimum of the two gaps
        // Gap size = number of consecutive bars + 1
        int side = Math.min(maxH + 1, maxV + 1);

        return side * side;
    }

    private int getMaxConsecutive(int[] bars) {
        int maxStreak = 1;
        int currentStreak = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
        }
        return maxStreak;
    }
}
