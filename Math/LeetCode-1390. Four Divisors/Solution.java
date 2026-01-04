class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int i : nums){
            ans += solve(i);
        }
        return ans;
    }
    public int solve(int num){
        int sqrt = (int) Math.sqrt(num);
        int sum = 0;
        int divisors = 0;
        for(int i = 1; i<=sqrt; i++){
            if(num%i == 0){
                int other = num/i;
                if(i == other){
                    divisors += 1;
                    sum += i;
                }else{
                    divisors += 2;
                    sum += i;
                    sum += other;
                }
            }
            if(divisors > 4) return 0;
        }
        return divisors == 4 ? sum:0;
    }

}
