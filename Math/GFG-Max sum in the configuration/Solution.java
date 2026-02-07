class Solution {
    int maxSum(int[] arr) {
        // code here
        int n = arr.length;
        int max = 0;
        int sum = 0;
        int val = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i]*i;
            val += arr[i];
        }
        max = sum;
        for(int i = 1; i<n; i++){
            int temp = sum - (val-arr[i-1]) + arr[i-1]*(n-1);
            max = Math.max(max, temp);
            sum = temp;
        }
        return max;
    }
}
