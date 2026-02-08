class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n) return "";
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i<m; i++){
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
        }
        int i = 0;
        int j = 0;
        int starti = 0;
        int required = m;
        int minWindowSize = Integer.MAX_VALUE;
        while(j<n){
            char c = s.charAt(j);
            if(mp.containsKey(c) && mp.get(c) > 0){
                required--;
            }
            mp.put(c, mp.getOrDefault(c, 0)-1);
            while(required == 0){
                int currSize = j-i+1;
                if(minWindowSize > currSize){
                    minWindowSize = currSize;
                    starti = i;
                }
                char left = s.charAt(i);
                mp.put(left, mp.get(left)+1);
                if(mp.get(left) > 0){
                    required++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(starti, starti+minWindowSize);
    }
}
