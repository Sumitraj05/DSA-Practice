class Solution {
    
    public int left(int[] arr, int tar){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] >= tar){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return i;
    }
    
    public int right(int[] arr, int tar){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] <= tar){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return j;
    }
    
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] q : queries){
            int left = left(arr, q[0]);
            int right = right(arr, q[1]);
            ans.add(right-left+1);
        }
        return ans;
    }
}
