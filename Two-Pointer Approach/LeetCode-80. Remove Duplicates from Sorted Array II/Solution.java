class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        int n = nums.length;
        for(int i = 2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j += 1;
            }
        }
        return j;
    }
}
