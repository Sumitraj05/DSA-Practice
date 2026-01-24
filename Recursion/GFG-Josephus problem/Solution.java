// class Solution {
//     public int josephus(int n, int k) {
//         // code here
//         int ans = 0;
//         for(int i = 1; i<=n; i++){
//             ans += k;
//             ans %= i;
//         }
//         return ans+1;
//     }
// }

class Solution {
    public int solve(int n, int k){
        if(n == 1){
            return 0;
        }
        return (solve(n-1, k)+k)%n;
    }
    public int josephus(int n, int k){
        return  solve(n, k)+1;
    }
}
