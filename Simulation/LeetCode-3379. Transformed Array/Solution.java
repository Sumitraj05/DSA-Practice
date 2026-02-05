class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                ans[i] = 0;
            }
            else if(nums[i] < 0){
                int idx = Math.abs(nums[i])%n;
                if(idx>i){
                    idx = n-Math.abs(i-idx);
                }else{
                    idx = i-idx;
                }
                ans[i] = nums[idx]; 
            }else{
                ans[i] = nums[(i+(nums[i]%n))%n];
            }
        }
        return ans;
    }
}
