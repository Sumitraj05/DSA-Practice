class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int i : set){
            if(!set.contains(i-1)){
                int cnt = 1;
                int x = i+1;
                while(set.contains(x)){
                    x += 1;
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
