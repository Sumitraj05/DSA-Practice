class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int high = arr.length-1;
        int low = 0;
        int ans = Integer.MAX_VALUE;
        int idx = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<ans){
                ans = arr[mid];
                idx = mid;
            }
            if(arr[mid] < arr[high]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return idx;
    }
}
