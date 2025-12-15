class Solution {
    public long getDescentPeriods(int[] arr) {
        long n = arr.length;
        long cnt = n;
        long x = 1;
        for(int i = 1; i<n; i++){
            if(arr[i-1]-arr[i] != 1){
                cnt += (x*(x-1))/2;
                x = 1;
            }else{
                x++;
            }
        }
        return cnt+((x*(x-1))/2);
    }
}
