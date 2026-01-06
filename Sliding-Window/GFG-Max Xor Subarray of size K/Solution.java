class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int sum = 0;
        int max = 0;
        int n = arr.length;
        for(int i = 0; i<k; i++){
            sum ^= arr[i];
        }
        max = Math.max(sum, max);
        int i = 0;
        int j = k;
        while(j<n){
            sum ^= arr[j];
            sum ^= arr[i];
            max = Math.max(max, sum);
            i++;
            j++;
        }
        return max;
    }
}
