// User function Template for Java

class Solution {
    
    public int search(int[] arr){
        int i = 0; 
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] == 1){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        int n = arr.length;
        if(j == -1) return n;
        if(i == n) return 0;
        if(arr[j] == 0 && arr[i] == 1) return n-i;
        return 0;
        
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max = 0;
        int ans = -1;
        int i = 0;
        for(int[] a : arr){
            int val = search(a);
            if(val > max){
                max = val;
                ans = i;
            }
            i++;
        }
        return ans;
    }
}
