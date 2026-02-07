class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = 0;
        int j = 0;
        int n = s.length();
        while(j<n){
            if(s.charAt(j) != ' ') j++;
            else{
                sb.insert(0, s.substring(i, j));
                sb.insert(0, ' ');
                while(s.charAt(j) == ' ') j++;
                i = j;
            }
        }
        sb.insert(0, s.substring(i, j));
        return sb.toString();
    }
}
