class Solution {
    public boolean isHappy(int n) {
        int j = 0;
        while(j++ < 7){
            int sum = 0;
            while(n > 0){
                int rem = n%10;
                sum += rem*rem;
                n = n/10;
            }
            if(sum == 1 || sum == 7) return true;
            n = sum;
        }
        return false;
    }
}
