class Solution {
    
    public int lower(int [] arr, int low, int high, int v){
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= v){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    
    public int uppar(int [] arr, int low, int high, int v){
  
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=v){
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        return high;
    }
    
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        int n = queries.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int low = queries[i][0];
            int high = queries[i][1];
            int v = queries[i][2];
            int lower = lower(arr, low, high, v);
            int uppar = uppar(arr, low, high, v);
            ans.add(uppar-lower+1);
        }
        return ans;
    }
}
