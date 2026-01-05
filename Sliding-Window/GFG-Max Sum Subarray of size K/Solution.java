class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int max = 0;
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += arr[i];
        }
        int i = 0;
        int j = k;
        int n = arr.length;
        while(j<n){
            max = Math.max(max, sum);
            sum -= arr[i];
            sum += arr[j];
            i++;
            j++;
        }
        max = Math.max(max, sum);
        return max;
    }
}
