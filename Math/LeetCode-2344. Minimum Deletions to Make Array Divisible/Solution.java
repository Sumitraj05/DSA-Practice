class Solution {
    public int GCD(int a, int b){
        return (b == 0) ? a : GCD(b, a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0];

        for(int i = 1; i<numsDivide.length; i++){
            g = GCD(g, numsDivide[i]);
        }

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){
            if(g%nums[i] == 0) return i;
        }
        return -1;
    }
}
