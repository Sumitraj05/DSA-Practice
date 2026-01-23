class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0; i<n; i++){
            while(!s1.isEmpty() && arr[i] > arr[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty()){
                left[i] = i+1;
            }else{
                left[i] = i-s1.peek();
            }
            s1.push(i);
        }
        
        for(int i = n-1; i>=0; i--){
            while(!s2.isEmpty() && arr[i] > arr[s2.peek()]){
                s2.pop();
            }
            if(s2.isEmpty()){
                right[i] = (n-1)-i+1;
            }else{
                right[i] = s2.peek()-i;
            }
            s2.push(i);
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, left[i]+right[i]-1);
        }
        return max;
    }
}
