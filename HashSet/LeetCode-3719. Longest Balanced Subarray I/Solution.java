class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for(int j = i; j<n; j++){
                if(nums[j]%2 == 0) set1.add(nums[j]);
                else set2.add(nums[j]);
                if(set1.size() == set2.size()){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}
