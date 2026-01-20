class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i<n; i++){
            int idx = nums.get(i);
            for(int j = 1; j<idx; j++){
                if((j | (j+1)) == idx){
                    res[i] = j;
                    break;
                } 
            }
        }
        return res;
    }
}
