class Solution {

    public int countCollisions(String d) {
        int i = 0;
        int j = d.length()-1;
        while(i<= j && d.charAt(i) == 'L'){
            i++;
        }
        while(i<=j && d.charAt(j) == 'R'){
            j--;
        }
        int cnt =0;
        while(i<=j){
            if(d.charAt(i) == 'L' || d.charAt(i) == 'R'){
                 cnt += 1;
            }
            i++;
        }
        return cnt;
    }
}
