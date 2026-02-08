// class Solution {
//     int maxProduct(int[] arr) {
//         // code here
//         int n = arr.length;
//         int max = arr[0];
//         int min = arr[0];
//         int ans = arr[0];
//         for(int i = 1; i<n; i++){
//             int temp = Math.max(max*arr[i], Math.max(min*arr[i], arr[i]));
//             min = Math.min(min*arr[i], Math.min(max*arr[i], arr[i]));
//             max = temp;
//             ans = Math.max(ans, max);
//         }
//         return ans;
//     }
// }

class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];
        for(int i = 1; i<n; i++){
            if(arr[i]<0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max*arr[i], arr[i]);
            min = Math.min(min*arr[i], arr[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
