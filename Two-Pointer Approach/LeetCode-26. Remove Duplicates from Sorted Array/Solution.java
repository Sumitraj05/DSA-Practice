class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        int j = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
