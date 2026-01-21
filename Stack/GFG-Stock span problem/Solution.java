class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int res = 0;
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(i-st.peek());
            }else{
                ans.add(i+1);
            }
            st.push(i);
        }
        return ans;
    }
}
