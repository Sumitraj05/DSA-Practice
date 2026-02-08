class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
       int n = s.length();
       int res = 0;
       int left = 0;
       for(int right = 0; right<n; right++){
        char c = s.charAt(right);
        if(map.containsKey(c)){
            left = Math.max(left, map.get(c)+1);
        }
        map.put(c, right);
        res = Math.max(res, right-left+1);
       }
       return res;
    }
}
