import java.util.*;

class Solution {
    class Room {
        long endTime;
        int id;
        public Room(long endTime, int id) {
            this.endTime = endTime;
            this.id = id;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        // 1. MUST SORT input
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>(); // Sorted by index
        for (int i = 0; i < n; i++) free.add(i);

        PriorityQueue<Room> busy = new PriorityQueue<>((a, b) -> {
            if (a.endTime != b.endTime) return Long.compare(a.endTime, b.endTime);
            return Integer.compare(a.id, b.id);
        });

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];

            // Free up rooms that finished before this meeting starts
            while (!busy.isEmpty() && busy.peek().endTime <= start) {
                free.add(busy.poll().id);
            }

            if (!free.isEmpty()) {
                int roomId = free.poll();
                count[roomId]++;
                busy.add(new Room(end, roomId));
            } else {
                // Wait for the earliest room to open
                Room earliest = busy.poll();
                count[earliest.id]++;
                // Delayed end time = room free time + meeting duration
                busy.add(new Room(earliest.endTime + (end - start), earliest.id));
            }
        }

        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }
}
