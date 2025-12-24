class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        int i = 0;
        int j = arr.length-1;
        Arrays.sort(arr);
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] <= x){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return i;
    }
}
