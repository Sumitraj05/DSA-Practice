class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int repeat = 0;
        int missing = 0;
        for(int i = 0; i<n; i++){
            int ind = Math.abs(arr[i])-1;
            if(arr[ind] < 0){
                repeat = Math.abs(arr[i]);
            }else{
                arr[ind] = -arr[ind];
            }
        }
        for(int i = 0; i<n; i++){
            if(arr[i] > 0) missing = i+1;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeat);
        ans.add(missing);
        return ans;
        
        
    }
}
