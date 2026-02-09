class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0; i<n; i++){
            String s = strs[i];
            char[] Char = s.toCharArray();
            Arrays.sort(Char);
            String sort = new String(Char);
            List<String> res = map.getOrDefault(sort, new ArrayList<>());
            res.add(s);
            map.put(sort, res);
        }
        for(Map.Entry<String, List<String>> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}
