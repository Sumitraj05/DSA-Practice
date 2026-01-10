class Solution {
    public int solve(String s, int k){
        int n = s.length();
        int sum = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j = 0; j<n; j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            while(map.size() >= k){
                sum += n-j;
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        return sum;
    }
    public int countSubstr(String s, int k) {
        //  code here
        return solve(s, k) - solve(s, k+1);
    }
}
