class Solution {
    public int minCandy(int arr[]) {
        int n = arr.length;
        int ans = 0;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for(int i = 0; i<n-1; i++){
            if(arr[i]<arr[i+1]){
                res[i+1] = res[i]+1;
            }
        }
        for(int i = n-1; i>0; i--){
            if(arr[i]<arr[i-1]){
                res[i-1] = Math.max(res[i-1] , res[i]+1);
            }
        }
        for(int i = 0; i<n; i++){
            ans += res[i];
        }
        return ans;
    }
}
