class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return ans;

        int n = s.length(), m = words.length, l = words[0].length();
        HashMap<String, Integer> mp = new HashMap<>();
        for(String word : words) mp.put(word, mp.getOrDefault(word, 0)+1);
        for(int i = 0; i<l; i++){
            int left = i;
            HashMap<String, Integer> seen = new HashMap<>();
            int count = 0;
            for(int j = i; j<=n-l; j += l){
                String sub = s.substring(j, j+l);
                if(mp.containsKey(sub)){
                    seen.put(sub, seen.getOrDefault(sub, 0)+1);
                    count++;
                    while(seen.get(sub) > mp.get(sub)){
                        String leftWord = s.substring(left, left+l);
                        seen.put(leftWord, seen.get(leftWord)-1);
                        count--;
                        left += l;
                    }
                    if(count == m){
                        ans.add(left);
                    }
                }else{
                    seen.clear();
                    count = 0;
                    left = j+l;
                }  
            }
        }
        return ans;
    }
}
