class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int del = 0;
        int b_Count = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == 'b'){
                b_Count++;
            }else{
                del = Math.min(del+1, b_Count);
            }
        }
        return del;
    }
}
