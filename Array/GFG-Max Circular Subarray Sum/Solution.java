

class Solution {
    public int MaxKadane(int[] arr, int n){
        int sum = arr[0];
        int MaxSum = arr[0];
        for(int i = 1; i<n; i++){
            sum = Math.max(sum+arr[i], arr[i]);
            MaxSum = Math.max(MaxSum, sum);
        }
        return MaxSum;
    }
     public int MinKadane(int[] arr, int n){
        int sum = arr[0];
        int MinSum = arr[0];
        for(int i = 1; i<n; i++){
            sum = Math.min(sum+arr[i], arr[i]);
            MinSum = Math.min(MinSum, sum);
        }
        return MinSum;
    }
    public int maxCircularSum(int arr[]) {
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        int MaxSum = MaxKadane(arr, n);
        int MinSum = MinKadane(arr, n);
        
        int CircularSum = sum-MinSum;
        if(MaxSum>0){
            return Math.max(MaxSum, CircularSum);
        }
        return MaxSum;
    }
}
