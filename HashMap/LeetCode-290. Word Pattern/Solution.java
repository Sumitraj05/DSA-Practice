class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, Integer> set1 = new HashMap<>();
        HashMap<String, Integer> set2 = new HashMap<>();
        String[] arr = s.split(" ");
        int n = arr.length;
        int m = pattern.length();
        if(n != m) return false;
        int i = 0;
        while(i<n){
            char c1 = pattern.charAt(i);
            String c2 = arr[i];
            if(!set1.containsKey(c1)){
                set1.put(c1, i);
            }
            if(!set2.containsKey(c2)){
                set2.put(c2, i);
            }
            if(!set1.get(c1).equals(set2.get(c2))) return false;
            i++;
        }
        return true;
    }
}
