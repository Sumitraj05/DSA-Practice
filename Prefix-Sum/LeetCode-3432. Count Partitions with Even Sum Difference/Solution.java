class Solution {
    public int countPartitions(int[] nums) {
        int TotalSum = 0;
        int ans = 0;
        int n = nums.length;
        for(int i : nums){
            TotalSum += i;
        }
        int sum = 0;
        for(int i = 0; i<n-1; i++){
            sum += nums[i];
            if(sum%2 == (TotalSum-sum)%2){
                ans++;
            }
        }
        return ans;
    }
}
