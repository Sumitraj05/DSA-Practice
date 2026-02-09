class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> set1 = new HashMap<>();
        HashMap<Character, Character> set2 = new HashMap<>();
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        int i = 0;
        while(i<n){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(set1.containsKey(c1) && set1.get(c1) != c2){
                return false;
            }
            if(set2.containsKey(c2) && set2.get(c2) != c1){
                return false;
            }
            set1.put(c1, c2);
            set2.put(c2, c1);
            i++;
        }
        return true;
    }
}
