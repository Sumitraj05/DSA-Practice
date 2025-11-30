class Solution {
    public int minSubarray(int[] nums, int p) {
        int rem = 0;
        for (int x : nums) rem = (rem + x) % p;
        if (rem == 0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int pre = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            pre = (pre + nums[i]) % p;
            if (mp.containsKey(((pre - rem + p) % p))) 
                res = Math.min(res, i - mp.get(((pre - rem + p) % p)));
            mp.put(pre, i);
        }
        return res == nums.length ? -1 : res;
    }
}
