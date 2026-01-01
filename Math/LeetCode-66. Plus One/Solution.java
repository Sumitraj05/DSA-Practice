class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] < 9){
            digits[n-1] += 1;
            return digits;
        }
        int carry = 1;
        digits[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            int val = digits[i]+carry;
            if(val < 10){
                digits[i] = val;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        for(int i = 1; i<=n; i++){
            ans[i] = 0;
        }
        return ans;
    }
}
