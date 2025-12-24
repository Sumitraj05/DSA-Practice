class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for(int i : apple){
            total += i;
        }
        int n = capacity.length;
        for(int i = n-1; i>=0; i--){
            if(total <= 0){
                return n-i-1;
            }
            total -= capacity[i];
        }
        if(total <= 0) return n;
        return -1;
    }
}
