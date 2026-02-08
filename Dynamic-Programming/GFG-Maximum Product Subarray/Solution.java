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
        int pref = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;
            pref *= arr[i];
            suff *= arr[n-1-i];
            ans = Math.max(ans, Math.max(pref, suff));
        }
        return ans;
    }
}
