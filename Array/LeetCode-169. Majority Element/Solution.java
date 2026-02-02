// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i : nums){
//             map.put(i, map.getOrDefault(i, 0)+1);
//         }
//         int ans = 0;
//         int res = 0;
//         for(Map.Entry<Integer, Integer> mp : map.entrySet()){
//             if(mp.getValue() > ans){
//                 ans = mp.getValue();
//                 res = mp.getKey();
//             }
//         }
//         return res;
//     }
// }

// Optimized
class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int n = nums.length;
        int val = 0;
        for(int i = 0; i<n; i++){
            if(majority == 0){
                majority = 1;
                val = nums[i];
            }
            else if(nums[i] == val){
                majority++;
            }else{
                majority--;
            }
        }
        return val;
    }
}
