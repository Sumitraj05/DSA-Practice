class Solution {
    public boolean possible(int mid, int[] arr, int k){
        int cnt = 0;
        for(int i : arr){
            if(i%mid == 0){
                cnt += i/mid;
            }else{
                cnt += (i/mid)+1;
            }
        }
        return cnt <= k;
    }
    public int kokoEat(int[] arr, int k) {
        // code her
        int low = 1;
        int high = -1;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            high = Math.max(high, arr[i]);
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, arr, k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
