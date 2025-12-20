class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int ans = 0;
        if(m == 1) return ans;
        int n = strs[0].length();
        int[] arr = new int[n];
        for(int i = 1; i<m; i++){
            String s1 = strs[i-1];
            String s2 = strs[i];
            for(int j = 0; j<n; j++){
                if(arr[j] != 0) continue;
                if(s1.charAt(j) > s2.charAt(j)){
                    ans++;
                    arr[j] = 1;
                }
            }
        }
        return ans;
    }
}
