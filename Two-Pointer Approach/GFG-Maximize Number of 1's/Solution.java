class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int i = 0;
        int j = 0;
        int n = arr.length;
        int max = 0;
        while(j<n){
            if(arr[j] == 1){
                j++;
            }
            else if(k>0){
                k--;
                j++;
            }else{
                while(arr[i] == 1){
                    i++;
                }
                k++;
                i++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}
