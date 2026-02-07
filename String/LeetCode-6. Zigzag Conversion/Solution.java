
class Solution {
    public String convert(String s, int numRows) {
         int n = s.length();
         char[] res = new char[n];
         if(n<=numRows || numRows == 1) return s;
         int diagonal = numRows-2;
         int OneSection = numRows+diagonal;
         int j = 0;
         for(int r = 0; r<numRows; r++){
            int i = r;
            while(i<n){
                res[j] = s.charAt(i);
                j++;
                i += OneSection;
                if(r>0 && r<numRows-1 && i-r*2 < n){
                    res[j] = s.charAt(i-r*2);
                    j++;
                }
            }
         }
         return new String(res);
    }
}
