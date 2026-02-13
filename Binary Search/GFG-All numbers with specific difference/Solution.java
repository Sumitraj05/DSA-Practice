class Solution {
    public int digitSum(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans += rem;
            n = n/10;
        }
        return ans;
    }
    public int getCount(int n, int d) {
        // code here
        if(d>=n || n<10) return 0;
        int low = 10;
        int high = n;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid-digitSum(mid)>=d){
                high = mid-1;
                ans = n-mid+1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
};
