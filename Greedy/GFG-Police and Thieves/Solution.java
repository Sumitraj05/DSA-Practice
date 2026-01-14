class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int i = 0;
        int j = 1;
        int ans = 0;
        int n = arr.length;
        while(i<n && j<n){
            char c1 = arr[i];
            char c2 = arr[j];
            if((c1 == 'P' && c2 == 'T') || (c1 == 'T' && c2 == 'P')){
                ans++;
                arr[i] = 'O';
                arr[j] = 'O';
                i++;
                j++;
            }
            else if(c1 == 'O'){
              i++;
              if(i == j){
                  j++;
              }
            } 
            else if(c2 == 'O') j++;
            else if((j-i)<k){
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}
