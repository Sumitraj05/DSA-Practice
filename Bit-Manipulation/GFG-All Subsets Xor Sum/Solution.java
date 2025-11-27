class Solution {
    int subsetXORSum(int arr[]) {
        // code here
         int res = 0;
        for(int i : arr){
            res |= i;
        }
        return res << (arr.length-1);
    }
}
