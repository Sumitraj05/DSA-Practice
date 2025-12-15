class Solution {
    public int cntWays(int[] arr) {
        // code here
        int even = 0;
        int odd = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                even += arr[i];   
            }else{
                odd += arr[i];
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                even -= arr[i];
                if(i != 0){
                    even += arr[i-1];
                }
            }else{
                odd -= arr[i];
                if(i != 0){
                    odd += arr[i-1];
                }
            }
            if(even == odd) cnt++;
        }
        return cnt;
    }
}
