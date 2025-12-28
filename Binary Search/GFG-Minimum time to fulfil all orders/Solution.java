class Solution {
    public int minTime(int[] ranks, int n) {
        // code here
        int low = 0;
        int high = 100000000;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(isPossible(ranks, n, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    
    public boolean isPossible(int[] ranks, int n, int mid){
        long totalCount = 0;
        
        for(int i : ranks){
            int time = 0;
            int count = 0;
            int nextRound = i;
            
            while(time+nextRound <= mid){
                time += nextRound;
                count++;
                nextRound += i;
            }
            totalCount += count;
            if(totalCount >= (long) n) return true;
        }
        return totalCount >= (long) n;
    }
}
