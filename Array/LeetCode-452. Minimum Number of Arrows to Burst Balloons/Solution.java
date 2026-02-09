class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int cnt = 0;
        int i = 0;
        int n = points.length;
        while(i<n){
            int currStart = points[i][0];
            int currEnd = points[i][1];
            int j = i+1;
            while(j<n && points[j][0]<=currEnd){
                currEnd = Math.min(currEnd, points[j][1]);
                currStart = Math.max(currStart, points[j][0]);
                j++;
            }
            cnt++;
            i = j;
        }
        return cnt;
    }
}
