class Solution {
    public int countBinarySubstrings(String s) {
        int prevCount = 0;
        int currCount = 1;
        int ans = 0;
        int n = s.length();
        for(int i = 1; i<n; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currCount++;
            }else{
                ans += Math.min(currCount, prevCount);
                prevCount = currCount;
                currCount = 1;
            }
        }
        ans += Math.min(currCount, prevCount);
        return ans;
    }
}
