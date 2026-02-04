class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1];
        for(int i = 0; i<n; i++){
            if(citations[i]>n){
                freq[n]++;
            }else{
                freq[citations[i]]++;
            }
        }
        int ans = 0;
        for(int i = n; i>=0; i--){
            ans += freq[i];
            if(ans >= i) return i;

        }
        return 0;
    }
}
