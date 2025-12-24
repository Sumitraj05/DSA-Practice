class Solution {
    public int binarySearch(int[] arr, int i, int j, int x){
        int temp = i;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(arr[mid] <= x){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return i-temp;
    }
    public int countLessEqual(int[] arr, int x) {
        // code here
        int i = 0;
        int j = arr.length-1;
        int rot = 0;
        while(i<j){
            int mid = i + (j-i)/2;
            if(arr[mid]>arr[j]){
                i = mid+1;
            }else{
                j = mid;
            }
        }
        rot = j;
        
        int count = binarySearch(arr, 0, rot-1, x);
        count += binarySearch(arr, rot, arr.length-1, x);
        return count;
        
    }
}
