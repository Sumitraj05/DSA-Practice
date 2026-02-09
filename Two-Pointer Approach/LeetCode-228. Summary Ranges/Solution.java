class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] != nums[i-1]+1){
                if(start == end){
                    String s = ""+start;
                    ans.add(s);
                }else{
                    String s = start+"->"+end;
                    ans.add(s);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if(start == end){
            String s = ""+start;
            ans.add(s);
        }else{
            String s = start+"->"+end;
            ans.add(s);
        }
        return ans;
    }
}
