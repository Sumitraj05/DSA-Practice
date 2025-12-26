class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int i = 1;
        int j = 0;
        int n = arr.length;
        while(j<n && k>0){
            if(arr[j] > i){
                k--;
            }else{
                j++;
            }
            i++;
        }
        if(k>0) return i+k-1;
        return i-1;
    }
}
