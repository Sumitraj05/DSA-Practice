class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int tempMax = 0;
        tempMax = findMax(0, k, arr);
        ans.add(tempMax);
        int n = arr.length;
        for(int i = 1; i<n-k+1; i++){
            if(arr[i-1] == tempMax){
                tempMax = findMax(i, i+k, arr);
            }else{
                tempMax = Math.max(tempMax, arr[i+k-1]);
            }
            ans.add(tempMax);
        }
        return ans;
    }
    int findMax(int start, int end, int[] arr){
        int max = 0;
        while(start<end){
            max = Math.max(max, arr[start]);
            start++;
        }
        return max;
    }
}
