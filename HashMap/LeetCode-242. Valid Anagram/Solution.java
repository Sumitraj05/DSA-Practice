class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        for(int i = 0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i = 0; i<n; i++){
            if(freq[t.charAt(i)-'a'] == 0) return false;
            freq[t.charAt(i)-'a']--;
        }
        return true;
    }
}
