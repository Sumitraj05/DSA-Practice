class Solution {
    
    public int atleast(int[] arr, int k){
        int n = arr.length;
        int i = 0;
        int cnt = 0;
        int sum = 0;
        for(int j = 0; j<n; j++){
            if((arr[j]&1) == 1){
                cnt++;
            }
            while(cnt == k){
                sum += (n-j);
                if((arr[i]&1) == 1){
                    cnt--;
                }
                i++;
            }
        }
        return sum;
        
    }
    public int countSubarrays(int[] arr, int k) {
        
        // TC - O(n) , SC - O(n);
        // code here
        // int cnt = 0;
        // int n = arr.length;
        // Queue<Integer> q = new LinkedList<>();
        // int i = 0;
        // int j = 0;
        // while(j<n){
        //     if(arr[j]%2 != 0){
        //         q.add(j);
        //     }
        //     if(q.size() == k){
        //         cnt += q.peek()-i+1;
        //     }
        //     if(q.size() > k){
        //         i = q.poll()+1;
        //         cnt += q.peek()-i+1;
        //     }
        //     j++;
        // }
        // return cnt;
        
        // TC - O(n) , SC - O(1);
        return atleast(arr, k) - atleast(arr, k+1); 
    }
}
